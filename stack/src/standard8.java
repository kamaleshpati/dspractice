import java.util.Scanner;
import java.util.Stack;

public class standard8 {
    static boolean isEqual(char c1, char c2) {
        switch (c1) {
            case '(':
                if (c2 == ')')
                    return true;
            case '{':
                if (c2 == '}')
                    return true;
            case '[':
                if (c2 == ']')
                    return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        String[] results = new String[test];
        for (int i = 0; i < test; i++) {
            results[i] = isBalanced(scanner.next());
        }
        for (String s : results)
            System.out.println(s);

    }

    private static String isBalanced(String next) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < next.length(); i++) {
            char ch = next.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (!s.isEmpty() && isEqual(s.peek(), ch)) {
                    s.pop();
                } else return "not balanced";
            }
        }
        if (s.isEmpty()) {
            return "balanced";
        } else
            return "not balanced";
    }
}