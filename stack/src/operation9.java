import java.util.Scanner;
import java.util.Stack;

public class operation9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverse(scanner.nextLine()));
    }

    private static String reverse(String next) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) != ' ') {
                stack.push(next.charAt(i));
            }
            else{
                while (!stack.isEmpty())
                    res+=stack.pop();
                res+=' ';
            }
        }
        while (!stack.isEmpty())
            res+=stack.pop();
        return res;
    }
}
