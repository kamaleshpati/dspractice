package binarytree;

public class SumTree {
    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (isSumTree(root) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }

    private static int isSumTree(Node node) {
        int ls;
        int rs;
        if (node == null || isLeaf(node) == 1)
            return 1;
        if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left) != 0)
                ls = node.left.key;
            else
                ls = 2 * (node.left.key);
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right) != 0)
                rs = node.right.key;
            else
                rs = 2 * (node.right.key);
            if ((node.key == rs + ls))
                return 1;
            else
                return 0;
        }
        return 0;
    }

    static int isLeaf(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return 0;
    }
}
