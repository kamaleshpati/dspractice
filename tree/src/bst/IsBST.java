package bst;

public class IsBST {
    public static void main(String args[]) {
        IsBST tree = new IsBST();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (tree.isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    private boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int minValue, int maxValue) {
        if (node == null)
            return true;
        if (node.key < minValue || node.key > maxValue)
            return false;
        return isBST(node.left, minValue, node.key) && isBST(node.right, node.key, maxValue);
    }

//    isBST(root,null,null)
//    boolean isBST(Node root, Node l, Node r) {
//        if (root == null)
//            return true;
//        if (l != null && root.key <= l.key)
//            return false;
//        if (r != null && root.key >= r.key)
//            return false;
//        return isBST(root.left, l, root) &&
//                isBST(root.right, root, r);
//    }
}
