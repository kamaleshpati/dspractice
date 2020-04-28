package binarytree;

public class TernaryToTree {
    public static void main(String[] args) {
        String exp = "a?b?c:d:e";
        char[] expression = exp.toCharArray();
        Node root = convertExpression(expression, 0);
        printTree(root);
    }

    private static Node convertExpression(char[] expression, int i) {
        if (i >= expression.length) {
            return null;
        }
        Node root = new Node(expression[i]);
        ++i;
        if (i < expression.length && expression[i] == '?') {
            root.left = convertExpression(expression, i + 1);
        }
        if (i < expression.length && expression[i] == ':') {
            root.right = convertExpression(expression, i + 1);
        }
        return root;
    }

    private static void printTree(Node root) {
        if (root == null)
            return;

        System.out.print((char)root.key + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
