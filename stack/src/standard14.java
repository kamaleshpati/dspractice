import java.util.Scanner;
import java.util.Stack;

public class standard14 {
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPost(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int bound = s.length();
        for (int i = 0; i < bound; i++) {
            Character character = s.charAt(i);
            if (Character.isDigit(character) || character.equals(" ")) {
                result.append(character);
            } else if (character.equals('(')) {
                stack.push(character);
            } else if (character.equals(')')) {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());

                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("invalid");
                    System.exit(0);
                } else
                    stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(character) <= Prec(stack.peek())) {
                    if (stack.peek().equals('(')) {
                        System.out.println("invalid");
                        System.exit(0);
                    }
                    result.append(stack.pop());
                }
                stack.push(character);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals('(')) {
                System.out.println("invalid");
                System.exit(0);
            }
            result.append(stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        float[] results = new float[test];
        for (int i = 0; i < test; i++) {
            results[i] = evaluate(scanner.next());
        }
//        for (float s : results)
//            System.out.println(s);
    }

    private static float evaluate(String next) {
        System.out.println(infixToPost(next));
        return 0;
    }
}
