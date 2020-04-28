package binarytree;

public class TreeTraversal {
    public static void main(String[] args)
    {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        System.out.println("Preorder traversal of binary tree is ");
        printPreorder(root);

        System.out.println("\nInorder traversal of binary tree is ");
        printInorder(root);

        System.out.println("\nPostorder traversal of binary tree is ");
        printPostorder(root);
    }

    private static void printPostorder(Tree root) {
        if(root==null){
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.value);
    }

    private static void printInorder(Tree root) {
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.value);
        printInorder(root.right);
    }

    private static void printPreorder(Tree root) {
        if(root==null){
            return;
        }
        System.out.println(root.value);
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
