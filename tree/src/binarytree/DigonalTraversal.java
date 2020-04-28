package binarytree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class DigonalTraversal {
    static Queue<Node> curr = new LinkedList();
    static Queue<Node> next = new LinkedList();

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        printLevelOrderUsingQueue(root);
        System.out.println();
        diagonalPrint(root);
        System.out.println();
        diagonalPrintUsingSingleQueue(root);
    }

    static void diagonalPrintUsingSingleQueue(Node root)
    {
        if (root == null)
            return;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);//delimeter
        while (q.size()>0) {
            Node temp = q.peek();
            q.remove();
            if (temp == null) {
                if (q.size()==0)
                    return;
                System.out.println();
                q.add(null);
            }
            else {
                while (temp!=null) {
                    System.out.print( temp.key + " ");
                    if (temp.left!=null)
                        q.add(temp.left);
                    temp = temp.right;
                }
            }
        }
    }

    private static void diagonalPrint(Node root) {
        if (root == null) {
            return;
        }
        curr.add(root);
        while (!curr.isEmpty()) {
            Node temp = curr.poll();
            if (temp.left != null)
                next.add(temp.left);
            if (temp.right != null)
                curr.add(temp.right);
            System.out.print(temp.key + " ");
            if (curr.isEmpty()) {
                System.out.println();
                Queue queue = curr;
                curr = next;
                next = queue;
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
            if (curr.isEmpty()) {
                System.out.println();
                Queue queue = curr;
                curr = next;
                next = queue;
            }
        }
    }

}
