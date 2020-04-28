package binarytree;

public class TreeFromINandPRE_INandLEVEL {
    private static int preIndex = 0;

    public static void main(String[] args) {
        TreeFromINandPRE_INandLEVEL obj = new TreeFromINandPRE_INandLEVEL();
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = obj.buildTree(in, pre, 0, len - 1);
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);

        int in1[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        Node node = obj.buildTree(in1, level);
        System.out.print("Inorder traversal of the constructed tree is ");
        printInorder(node);
    }

    private static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        //maket char for 1st case
        
        System.out.println(root.key);
        printInorder(root.right);
    }

    Node buildTree(int in[], int level[]) {
        Node startnode = null;
        return constructTree(startnode, level, in, 0, in.length - 1);
    }

    Node constructTree(Node startNode, int[] levelOrder, int[] inOrder,
                       int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        if (inStart == inEnd)
            return new Node(inOrder[inStart]);
        boolean found = false;
        int index = 0;
        for (int i = 0; i < levelOrder.length - 1; i++) {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) {
                if (data == inOrder[j]) {
                    startNode = new Node(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found == true)
                break;
        }
        startNode.left = (constructTree(startNode, levelOrder, inOrder,
                inStart, index - 1));
        startNode.right = (constructTree(startNode, levelOrder, inOrder,
                index + 1, inEnd));

        return startNode;
    }

    private Node buildTree(char[] in, char[] pre, int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;
        Node tNode = new Node(pre[preIndex++]);
        if (inStrt == inEnd)
            return tNode;
        int inIndex = search(in, inStrt, inEnd, (char) tNode.key);
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    int search(char[] arr, int strt, int end, char value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}
