package binarytree;

public class PerfectBinaryTree {
    public static void main(String args[])
    {
        Node root = null;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
//        root.right.right = new Node(70);

        if (isPerfect(root) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isPerfect(Node root) {
     int height = findADepth(root);
        return isPerfectRec(root, height, 0);
    }

    private static boolean isPerfectRec(Node root, int height, int i) {
        if(root==null)
            return true;
        if (root.left == null && root.right == null)
            return (height == i+1);
        if(root.left==null && root.right!=null || root.left!=null && root.right==null)
            return false;
//        if (root.left == null || root.right == null)
//            return false; //alternate for above mentioned
        return (isPerfectRec(root.right,height,i+1) && isPerfectRec(root.left,height,i+1));
    }

    static int findADepth(Node node)
    {
        int d = 0;
        while (node != null)
        {
            d++;
            node = node.left;
        }
        return d;
    }
}
