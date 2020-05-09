package bst;

public class DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 30);
        insert(root, 25);
        insert(root, 35);
        System.out.println(findDist(root, 5, 35));
    }

    private static int findDist(Node root, int first, int second) {
        if (root == null) {
            return 0;
        }
        if (first < root.key && second < root.key) {
            return findDist(root.left, first, second);
        }
        if (first > root.key && second > root.key) {
            return findDist(root.right, first, second);
        }
        if (first <= root.key && second >= root.key)
            return findDist(root.left, first) + findDist(root.right, second);
        if (first >= root.key && second <= root.key)
            return findDist(root.right, first) + findDist(root.left, second);
        return 0;
    }

    private static int findDist(Node root, int ele) {
        if (root.key == ele)
            return 1;
        else if (root.key > ele)
            return 1 + findDist(root.left, ele);
        return 1 + findDist(root.right, ele);
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
}
