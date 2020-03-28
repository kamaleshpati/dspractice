import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class misc6 {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right;
        }
    }

    static Node root;

    public static void main(String args[]) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Height of tree is " + treeHeight(root));
        System.out.println("Height of tree is " + treeHeightQueue(root));
    }

    static int treeHeightQueue(Node node) {
        if (node == null)
            return 0;
        Queue<Node> q = new LinkedList();
        q.add(node);
        int height = 0;
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0) {
                System.out.println();
                Iterator iterator=q.iterator();
                while (iterator.hasNext())
                    System.out.print(((Node)iterator.next()).data);
                Node newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }

    private static int treeHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int noderight = 1;
        int nodeleft = 1;
        noderight += treeHeight(root.right);
        nodeleft += treeHeight(root.left);
        return (nodeleft > noderight ? nodeleft : noderight);
    }
}
