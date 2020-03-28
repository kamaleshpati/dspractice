import java.util.Scanner;
import java.util.Stack;

public class standard14_15_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String string1 = infixToPostFix(string);
        System.out.println(evaluatePostFix(string1));
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

    static String infixToPostFix(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int bound = s.length();
        for (int i = 0; i < bound; i++) {
            Character character = s.charAt(i);
            if (character != ' ') {
                if (Character.isDigit(character)) {
                    StringBuffer ele=new StringBuffer();
                    while (i<s.length()&&Character.isDigit(s.charAt(i))){
                        ele.append(s.charAt(i));
                        i++;
                    }
                    System.out.println(ele);
                    result.append(" " + ele + " ");
                    i--;
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
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals('(')) {
                System.out.println("invalid");
                System.exit(0);
            }
            result.append(stack.pop());
        }
        System.out.println(result.toString());
        return result.toString();
    }

    private static int evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuffer ele=new StringBuffer();
                while (Character.isDigit(s.charAt(i))){
                    ele.append(s.charAt(i));
                    i++;
                }
                stack.push(Integer.parseInt(String.valueOf(ele)));
                i--;
            } else {
                if (ch != ' ') {
                    int res = 0;
                    try {
                        res = evaluate(stack.pop(), stack.pop(), ch);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    stack.push(res);
                }
            }
        }
        return stack.pop();
    }

    private static int evaluate(Integer pop, Integer pop1, char ch) throws Exception {
        switch (ch) {
            case '+':
                return pop1 + pop;
            case '-':
                return pop1 - pop;
            case '*':
                return pop1 * pop;
            case '/':
                if (pop == 0)
                    throw new Exception("diveded byzero");
                return pop1 / pop;
            case '^':
                return (int) Math.pow(pop, pop1);
            default:
                return 0;
        }
    }
}
