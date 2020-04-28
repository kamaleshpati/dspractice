package binarytree;

public class NthNodeInInorderPostorder {
    static int count = 0;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        int n = 4;
        NthInorder(root, n);
        root = new Node(25);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(18);
        root.left.right = new Node(22);
        root.right.left = new Node(24);
        root.right.right = new Node(32);
        int N = 6;
        count = 0;
        NthPostordernode(root, N);
    }

    private static void NthPostordernode(Node node, int n) {
        if (node == null)
            return;
        if (count <= n) {
            NthPostordernode(node.left, n);
            NthPostordernode(node.right, n);
            count++;
            if (count == n)
                System.out.print(node.key);
        }
    }

    private static void NthInorder(Node node, int n) {
        if (node == null)
            return;
        if (count <= n) {
            NthInorder(node.left, n);
            count++;
            if (count == n)
                System.out.printf("%d ", node.key);
            NthInorder(node.right, n);
        }
    }
}
