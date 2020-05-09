package bst;

import java.util.ArrayList;

public class AllPossibeBST {
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String args[]) {
        ArrayList<Node> totalTreesFrom1toN = constructTrees(1, 3);
        System.out.println("Preorder traversals of all constructed BSTs are ");
        for (int i = 0; i < totalTreesFrom1toN.size(); i++) {
            preorder(totalTreesFrom1toN.get(i));
            System.out.println();
        }
    }

    private static ArrayList<Node> constructTrees(int start, int end) {
        ArrayList<Node> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<Node> leftSubtree = constructTrees(start, i - 1);
            ArrayList<Node> rightSubtree = constructTrees(i + 1, end);
            for (int j = 0; j < leftSubtree.size(); j++) {
                Node left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    Node right = rightSubtree.get(k);
                    Node node = new Node(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
