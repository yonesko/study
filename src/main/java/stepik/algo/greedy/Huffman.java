package stepik.algo.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Huffman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        Map<Character, String> codes = buildCodes(input);
        String encoded = encode(input, codes);

        System.out.println(String.format("%d %d", codes.size(), encoded.length()));
        codes.forEach((character, code) -> System.out.println(String.format("%c: %s", character, code)));
        System.out.println(encoded);
    }

    static Map<Character, String> buildCodes(String input) {
        Map<Character, Integer> letterToCount = input.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toMap(t -> t, t -> 1, (o, o2) -> o + o2));

        PriorityQueue<Node> tree = new PriorityQueue<>(Comparator.comparingInt(Node::getCount).reversed());

        letterToCount.forEach((letter, count) -> tree.add(new LeafNode(count, letter)));

        List<Node> twoLowest = tree.stream()
                .sorted(Comparator.comparingInt(Node::getCount))
                .limit(2)
                .collect(Collectors.toList());

        while (twoLowest.size() > 1) {
            Node left = twoLowest.get(0);
            Node right = twoLowest.get(1);
            ParentNode parent = new ParentNode(left.getCount() + right.getCount(), left, right);
            tree.add(parent);

            twoLowest = tree.stream()
                    .sorted(Comparator.comparingInt(Node::getCount))
                    .filter(node -> node.parent == null)
                    .limit(2)
                    .collect(Collectors.toList());
        }

        Node root = tree.poll();
        Map<Character, String> codes = new HashMap<>();
        if (root instanceof ParentNode) {
            buildCodes(codes, (ParentNode) root, "");
        } else if (root instanceof LeafNode) {
            codes.put(((LeafNode) root).getVal(), "0");
        }

        return codes;
    }

    static String encode(String input) {
        return encode(input, buildCodes(input));
    }

    static String encode(String input, Map<Character, String> codes) {
        return input.chars().mapToObj(i -> (char) i).map(codes::get).collect(Collectors.joining());
    }

    private static void buildCodes(Map<Character, String> codes, ParentNode root, String path) {
        Node left = root.getLeft();
        Node right = root.getRight();

        if (left instanceof LeafNode) codes.put(((LeafNode) left).getVal(), path + '0');
        else if (left instanceof ParentNode) buildCodes(codes, (ParentNode) left, path + '0');

        if (right instanceof LeafNode) codes.put(((LeafNode) right).getVal(), path + '1');
        else if (right instanceof ParentNode) buildCodes(codes, (ParentNode) right, path + '1');
    }
}
