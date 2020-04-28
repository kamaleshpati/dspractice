package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalPluSpiralTraversal {
    static Queue<Node> curr = new LinkedList();
    static Queue<Node> next = new LinkedList();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
        printLevelOrderUsingQueue(root);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        printLevelOrderSpiral(root);
    }

    private static void printLevelOrderSpiral(Node node) {
        int height = findHeight(node);
        System.out.println(height);
        for (int i = 1; i <= height; i++) {
            printLevelSpiral(node, i,i%2==0);
            System.out.println();
        }
    }

    private static void printLevelSpiral(Node node, int height, boolean spiral) {
        if (node == null)
            return;
        if (height == 1)
            System.out.print(node.key + " ");
        else if (height > 1) {
            if(spiral){
                printLevelSpiral(node.left, height - 1,spiral);
                printLevelSpiral(node.right, height - 1,spiral);
            }
            else {
                printLevelSpiral(node.right, height - 1,spiral);
                printLevelSpiral(node.left, height - 1,spiral);
            }
        }
    }

    private static void printLevelOrderUsingQueue(Node root) {
        if (root == null) {
            return;
        }
        curr.add(root);
        while (!curr.isEmpty()) {
            Node temp = curr.poll();
            if (temp.left != null)
                next.add(temp.left);
            if (temp.right != null)
                next.add(temp.right);
            System.out.print(temp.key + " ");
            if(curr.isEmpty()){
                System.out.println();
                Queue queue = curr;
                curr = next;
                next = queue;
            }
        }
    }

    private static void printLevelOrder(Node node) {
        int height = findHeight(node);
        System.out.println(height);
        for (int i = 1; i <= height; i++) {
            printLevel(node, i);
            System.out.println();
        }
    }

    private static void printLevel(Node node, int height) {
        if (node == null)
            return;
        if (height == 1)
            System.out.print(node.key + " ");
        else if (height > 1) {
            printLevel(node.left, height - 1);
            printLevel(node.right, height - 1);
        }
    }

    private static int findHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = findHeight(node.left);
        int rHeight = findHeight(node.right);
        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }
}
