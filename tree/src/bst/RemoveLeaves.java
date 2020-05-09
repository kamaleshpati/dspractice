package bst;

public class RemoveLeaves {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 30);
        insert(root, 25);
        insert(root, 35);
        inorder(root);
        leafDelete(root);
        System.out.println();
        inorder(root);
    }

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (x < root.key)
            root.left = insert(root.left, x);
        else if (x > root.key)
            root.right = insert(root.right, x);
        return root;
    }

    static void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    static Node leafDelete(Node root)
    {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = leafDelete(root.left);
        root.right = leafDelete(root.right);

        return root;
    }
}
