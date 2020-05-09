package bst;

public class BSTfromLevelOrderTraversal {
    static Node LevelOrder(Node root , int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }
        if(data <= root.key)
            root.left = LevelOrder(root.left, data);
        else
            root.right = LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n)
    {
        if(n == 0)return null;
        Node root = null;

        for(int i = 0; i < n; i++)
            root = LevelOrder(root , arr[i]);

        return root;
    }

    static void inorderTraversal(Node root)
    {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print( root.key + " ");
        inorderTraversal(root.right);
    }


    public static void main(String args[])
    {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n = arr.length;
        Node root = constructBst(arr, n);
        System.out.print( "Inorder Traversal: ");
        inorderTraversal(root);
    }
}
