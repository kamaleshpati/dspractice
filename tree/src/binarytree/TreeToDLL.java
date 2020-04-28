package binarytree;

public class TreeToDLL {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        System.out.println("Inorder Tree Traversal");
        inorder(root);

        Node head = treeToDLL(root);

        System.out.println("\nDLL Traversal");
        printlist(head);
    }

    private static Node treeToDLL(Node root) {
        if(root == null)
            return root;
        if(root.right!=null){
             Node left = treeToDLL(root.left);
            for (; left.right != null; left = left.right);
            left.right = root;
            root.left = left;
        }
        if (root.right != null)
        {
            Node right = treeToDLL(root.right);
            for (; right.left != null; right = right.left);
            right.left = root;
            root.right = right;
        }
        while (root.left != null)
            root = root.left;
        return root;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
    static void printlist(Node root)
    {
        while (root != null)
        {
            System.out.print(root.key + " ");
            root = root.right;
        }
    }
}
