package binarytree;

public class BST {
    Node root;
    BST() {
        root = null;
    }
    Node insert(int key) {
        root = insertRec(root, key);
        return root;
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
}
