package binarytree;

public class PostFromBST {
    public static void main(String[] args)
    {
        int[] pre = { 40, 30, 32, 35, 80, 90 ,100 ,120 };
        BST BST = new BST();
        Node root = null;
        for (int i = 0; i < pre.length; i++) {
            root=BST.insert(pre[i]);
        }
        printPostorder(root);
    }

    private static void printPostorder(Node root) {
        if(root==null){
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.key);
    }
}
