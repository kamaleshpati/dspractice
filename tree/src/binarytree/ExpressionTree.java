package binarytree;

import java.util.Stack;

public class ExpressionTree {
    static boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    static void inorder(Tree t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }
    static Tree constructTree(char postfix[]) {
        Stack<Tree> st = new Stack();
        Tree t, t1, t2;
        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                t = new Tree(postfix[i]);
                st.push(t);
            } else
            {
                t = new Tree(postfix[i]);
                t1 = st.pop();
                t2 = st.pop();
                t.right = t1;
                t.left = t2;
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }

    public static void main(String args[]) {
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Tree root = constructTree(charArray);
        inorder(root);
    }

}
