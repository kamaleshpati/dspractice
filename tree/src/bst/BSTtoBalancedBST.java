package bst;

import java.util.Vector;

public class BSTtoBalancedBST {
    Node root;

    public static void main(String[] args) {
        BSTtoBalancedBST tree = new BSTtoBalancedBST();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }

    private Node buildTree(Node root) {
        Vector<Node> nodes = new Vector<>();
        storeBSTNodes(root, nodes);
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    Node buildTreeUtil(Vector<Node> nodes, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);
        return node;
    }

    private void storeBSTNodes(Node root, Vector<Node> nodes) {
        if (root == null)
            return;
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }


    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
