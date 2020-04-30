package binarytree;

public class CousinNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int val = 5;
        int level = findLevel(root,val,0);
        PrintCousinNodes(root,level ,val);
    }

    private static int findLevel(Node root, int val, int level) {
        if (root == null)
            return 0;
        if (root.key == val)
            return level;
        int downlevel = findLevel(root.left, val, level+1);
        if (downlevel != 0)
            return downlevel;
        return findLevel(root.right, val, level+1);
    }

    static void PrintCousinNodes(Node root, int level,int val) {
        if (root == null || level < 2)
            return;
        if (level == 2)
        {
            if (root.left.key == val || root.right.key == val)
                return;
            if (root.left != null)
                System.out.print(root.left.key + " ");
            if (root.right != null)
                System.out.print(root.right.key + " ");
        }
        else if (level > 2)
        {
            PrintCousinNodes(root.left, val, level-1);
            PrintCousinNodes(root.right, val, level-1);
        }
    }


}
