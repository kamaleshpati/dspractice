import java.util.Scanner;
import java.util.Stack;

public class standard1_6 {
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
            if (Character.isAlphabetic(character)) {
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

    static String infixToPre(String s) {
        return postfixToPre(infixToPost(s));
    }
    static String prefixToIn(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                String temp = "(" + stack.pop() + c + stack.pop() + ")";
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    static String prefixToPost(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                String temp = stack.pop() + stack.pop() + c;
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    static String postfixToPre(String expression) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isLetterOrDigit(expression.charAt(i))) {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = expression.charAt(i) + op2 + op1;
                s.push(temp);
            } else {
                s.push(expression.charAt(i) + "");
            }
        }
        return s.peek();
    }

    static String postfixToIn(String expression) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isLetterOrDigit(expression.charAt(i))) {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = "(" + op2 + expression.charAt(i) + op1 + ")";
                s.push(temp);
            } else {
                s.push(expression.charAt(i) + "");
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        String[] results = new String[test];
        for (int i = 0; i < test; i++) {
            results[i] = infixToPost(scanner.next());
        }
        for (String s : results)
            System.out.println(s);

    }
}
