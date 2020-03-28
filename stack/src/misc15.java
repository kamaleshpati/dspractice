import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class misc15 {
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
        List<Character> s1 = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            Character character = s.charAt(i);
            if (Character.isAlphabetic(character)) {
                result.append(character);
            } else if (character.equals('(')) {
                stack.push(character);
            } else if (character.equals(')')) {
                while (!stack.isEmpty() && stack.peek() != '(')
                    s1.add(stack.pop());
                System.out.println(s1);
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("invalid");
                    System.exit(0);
                } else
                    stack.pop();
                if (stack.peek() == '-') {
                    for (int j = 0; j < s1.size(); j++) {
                        if (s1.get(j) == '+')
                            s1.add(j, '-');
                        else if (s1.get(j) == '-')
                            s1.add(j, '+');
                        System.out.println(s1);
                    }
                }
                for (int j = 0; j <s1.size() ; j++) {
                    result.append(s1.get(j));
                }
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
        String[] results = new String[test];
        for (int i = 0; i < test; i++) {
            results[i] = infixToPost(scanner.next());
        }
        for (String s : results)
            System.out.println(s);

    }
}
