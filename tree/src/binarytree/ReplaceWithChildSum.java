package binarytree;

public class ReplaceWithChildSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new  Node(6);
        root.right.right = new Node(7);
        printpreorder(root);
        replaceWithSum(root);
        printpreorder(root);
    }

    private static void replaceWithSum(Node root) {
        if(root==null)
            return;
        if(root.left!=null && root.right!=null){
            root.key=root.left.key+root.right.key;
            replaceWithSum(root.left);
            replaceWithSum(root.right);
        }
        if(root.left!=null && root.right==null){
            root.key=root.left.key;
            replaceWithSum(root.left);
        }
        else {
            root.key=root.right.key;
            replaceWithSum(root.right);
        }
    }

    private static void printpreorder(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.key);
        printpreorder(root.left);
        printpreorder(root.right);
    }
}
