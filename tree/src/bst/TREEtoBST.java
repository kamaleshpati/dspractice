package bst;

public class TREEtoBST {
    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        // convert Binary Tree to BST 
        binaryTreeToBST (root);

        printInorder(root);

    }

    private static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    private static void binaryTreeToBST(Node root) {
        int n = countNodes (root);
    }

    private static int countNodes(Node root) {
        if (root == null)
            return 0;
        return countNodes (root.left) +
                countNodes (root.right) + 1;
    }
}
