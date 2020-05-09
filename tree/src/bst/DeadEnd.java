package bst;

public class DeadEnd {
    public static void main(String[] args) {

        Node root = null;
        int keys[] = {8,5,2,3,7,11,4};
        for (int x : keys)
            root = insert(root, x);
        isDeadEndExist(root);
    }

    private static void isDeadEndExist(Node root) {
        if(deadEnd(root,root.key,Integer.MAX_VALUE))
            System.out.println("dead end");
        else{
            System.out.println("no dead end");
        }
    }

    private  static boolean deadEnd(Node root, int min, int max)
    {
        if (root==null)
            return false;
        if (min == max)
            return true;
        return deadEnd(root.left, min, root.key - 1)||
                deadEnd(root.right, root.key + 1, max);
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
}
