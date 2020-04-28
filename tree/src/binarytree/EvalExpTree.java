package binarytree;

public class EvalExpTree {
    public static void main(String[] args) {
        Tree root = new Tree("+");
        root.left = new Tree("*");
        root.left.left = new Tree("5");
        root.left.right = new Tree("-4");
        root.right = new Tree("-");
        root.right.left = new Tree("100");
        root.right.right = new Tree("20");
        System.out.printf(String.valueOf(eval(root)));
    }

    private static double eval(Tree root) {
        if (root == null)
            return 0.0;
        if (root.left == null && root.right == null) {
            System.out.println(root.value);
            return Double.parseDouble(String.valueOf(root.value));
        }
        double left = eval(root.left);
        double right = eval(root.right);
        switch (String.valueOf(root.value)) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return Math.pow(left, right);
        }
    }
}
