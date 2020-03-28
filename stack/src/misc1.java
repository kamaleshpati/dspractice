import java.util.Stack;

public class misc1 {
    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
        }
    }

    static void postOrderIterative(node root) {
        Stack<node> s1 = new Stack<>();
        Stack<node> s2 = new Stack<>();
        if (root == null)
            return;
        s1.push(root);
        while (!s1.isEmpty()) {
            node temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()) {
            node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
        postOrderIterative(root);
    }
}
