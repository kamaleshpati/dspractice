package binarytree;

public class PostInTreeConstruction {
    private static int preIndex = 0;
    public static void main(String[] args)
    {
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        preIndex = in.length-1;
        Node root = buildTree(in, post,0,in.length-1);
        System.out.println("Preorder of the constructed tree : ");
        preOrder(root);
    }

    private static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    private static Node buildTree(int[] in, int[] post, int start, int end) {
        if(start>end)
            return null;
        Node node = new Node(post[preIndex]);
        preIndex--;
        if (start == end)
            return node;
        int iIndex = search(in, start, end, node.key);
        node.right = buildTree(in, post, iIndex + 1, end);
        node.left = buildTree(in, post, start, iIndex - 1);

        return node;
    }

    private static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
