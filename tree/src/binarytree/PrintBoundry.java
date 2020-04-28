package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBoundry {

    static Queue<Node> curr = new LinkedList();
    static Queue<Node> next = new LinkedList();

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        printLevelOrderUsingQueue(root);
        System.out.println();
        printBoundary(root);
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
            if (curr.isEmpty()) {
                System.out.println();
                Queue queue = curr;
                curr = next;
                next = queue;
            }
        }
    }

    private static void printBoundary(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + "\n");
        printBoundaryLeft(node.left);
        printBoundaryLeaf(node);
        printBoundaryRight(node.right);
    }

    private static void printBoundaryLeft(Node node) {
        if(node == null){
            return;
        }
        //System.out.println(node.key);
        if(node.left!=null){
            System.out.println(node.key);
            printBoundaryLeft(node.left);
        }
        else if(node.right!=null){
            System.out.println(node.key);
            printBoundaryLeft(node.right);
        }
    }

    private static void printBoundaryLeaf(Node node) {
        if(node == null){
            return;
        }
        if(node.left!=null){
            printBoundaryLeaf(node.left);
        }
        if(node.left==null &&node.right==null)
            System.out.println(node.key);
        else if(node.right!=null){
            printBoundaryLeaf(node.right);
        }
    }

    private static void printBoundaryRight(Node node) {
        if(node == null){
            return;
        }
        //System.out.println(node.key);
        if(node.right!=null){
            System.out.println(node.key);
            printBoundaryRight(node.right);
        }
        if(node.left!=null){
            System.out.println(node.key);
            printBoundaryRight(node.left);
        }
    }
}
