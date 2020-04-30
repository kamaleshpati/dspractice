package binarytree;

import java.util.*;

public class LCA1 {
    Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    public static void main(String[] args) {
        LCA1 tree = new LCA1();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));

        System.out.println("LCA(4, 5): " + tree.findLCAEffect(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCAEffect(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCAEffect(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCAEffect(2,4));

    }

    private int findLCAEffect(int n1, int n2) {
        return findLCASingleTime(root, n1, n2).key;
    }

    private Node findLCASingleTime(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.key == n1 || root.key == n2)
            return root;
        Node left_lca = findLCASingleTime(root.left, n1, n2);
        Node right_lca = findLCASingleTime(root.right, n1, n2);
        if (left_lca!=null && right_lca!=null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
    }

    private int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(Node root, int n1, int n2) {
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
    }

    private boolean findPath(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
        path.add(root.key);
        if (root.key == n) {
            return true;
        }
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
