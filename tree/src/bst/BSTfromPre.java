package bst;

public class BSTfromPre {
    private int track = 0;
    public static void main(String[] args) {
        BSTfromPre tree = new BSTfromPre();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    private Node constructTree(int[] pre, int size) {
       return constructTreeUtil(pre[track],pre,size,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private Node constructTreeUtil(int key, int[] pre, int size, int maxValue, int minValue) {
        if(track>=size)
            return null;
        Node root = null;
        if(key<maxValue && key>minValue){
            root = new Node(key);
            track++;
            if(track<size){
                root.left=constructTreeUtil(pre[track],pre,size,key,minValue);
                root.right=constructTreeUtil(pre[track],pre,size,maxValue,key);
            }
        }
        return root;
    }
}
