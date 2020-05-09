package bst;

public class SumKElements {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        root = insert(root, 22);
        int k = 3;
        System.out.println(ksmallestElementSumRec(root,k,0));
    }

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (x < root.key)
            root.left = insert(root.left, x);
        else if (x > root.key)
            root.right = insert(root.right, x);
        return root;
    }

    static int ksmallestElementSumRec(Node root, int k, int count)
    {
        if (root == null)
            return 0;
        if (count > k)
            return 0;
        int res = ksmallestElementSumRec(root.left, k, count);
        if (count >= k)
            return res;
        res += root.key;
        count++;
        if (count >= k)
            return res;
        return res + ksmallestElementSumRec(root.right, k, count);
    }

}
