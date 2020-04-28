package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeFromParentArray {
    static Node root;
    public static void main(String[] args) {
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        Node node = createTree(parent);
        System.out.println("Inorder traversal of constructed tree ");
        inorder(node);
    }

    private static Node createTree(int[] parent) {
        Node[] created = new Node[parent.length];
        for (int i = 0; i < parent.length; i++)
            createNode(parent, i, created);
        return root;
    }

    private static void createNode(int[] parent, int i, Node[] created) {
        if (created[i] != null)
            return;
        created[i] = new Node(i);
        if (parent[i] == -1)
        {
            root = created[i];
            return;
        }
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);
        Node p = created[parent[i]];
        if (p.left == null)
            p.left = created[i];
        else
            p.right = created[i];
    }

    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
}
