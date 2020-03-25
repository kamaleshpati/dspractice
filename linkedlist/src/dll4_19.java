public class dll4_19 {
    static class TreeNode
    {
        int val;
        TreeNode left,right;

        public TreeNode(int val)
        {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode root;
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }
    static Node head;
    public static void main(String args[])
    {
        TreeNode treeNode = new TreeNode(10);
        root=treeNode;
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        printPostorder(root);
        convertTreeToDLL(root);
        System.out.println();
        printDouble();
    }

    private static void convertTreeToDLL(TreeNode node) {
        if (node == null)
            return;
        convertTreeToDLL(node.left);
        addToDLL(new Node(node.val));
        convertTreeToDLL(node.right);
    }

    private static void addToDLL(Node node) {
        Node temp = head;
        if(head==null){
            head=node;
        }
        else{
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    static void printPostorder(TreeNode node)
    {
        if (node == null)
            return;
        printPostorder(node.left);
        System.out.print(node.val + " ");
        printPostorder(node.right);
    }

    private static void printDouble() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
}
