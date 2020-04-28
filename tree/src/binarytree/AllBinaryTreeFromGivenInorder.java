package binarytree;

import java.util.Vector;

public class AllBinaryTreeFromGivenInorder {
    public static void main(String args[]) {
        int in[] = {4, 5, 7};
        int n = in.length;
        Vector<Node> trees = getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different "+
                " binary trees are:");
        for (int i = 0; i < trees.size(); i++) {
            preOrder(trees.get(i));
            System.out.println("");
        }
    }

    private static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " "    );
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static Vector<Node> getTrees(int[] in, int start, int end) {
        Vector<Node> trees = new Vector<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        for (int i = start; i <=end  ; i++) {
            Vector<Node> ltrees = getTrees(in, start, i - 1);
            Vector<Node> rtrees = getTrees(in, i+1, end);
            for (int j = 0; j < ltrees.size(); j++) {
                for (int k = 0; k < rtrees.size(); k++) {
                    Node node = new Node(in[i]);
                    node.left = ltrees.get(j);
                    node.right = rtrees.get(k);
                    trees.add(node);
                }
            }
        }
        return trees;
    }
}
