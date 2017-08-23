package stepik.algo.greedy;

public abstract class Node {
    private static int countId = 0;
    protected final int count;
    protected final int id = countId++;
    protected ParentNode parent;


    public Node(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Node getParent() {
        return parent;
    }
}

class LeafNode extends Node {
    private final char val;

    public LeafNode(int count, char val) {
        super(count);
        this.val = val;
    }

    public char getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "LeafNode{" +
                "count=" + count +
                ", id=" + id +
                ", parent=" + (parent == null ? null : parent.id) +
                ", val=" + val +
                '}';
    }
}

class ParentNode extends Node {
    private final Node left, right;

    public ParentNode(int count, Node left, Node right) {
        super(count);
        this.left = left;
        this.right = right;
        left.parent = right.parent = this;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "ParentNode{" +
                "count=" + count +
                ", id=" + id +
                ", parent=" + (parent == null ? null : parent.id) +
                ", left=" + left.id +
                ", right=" + right.id +
                '}';
    }
}