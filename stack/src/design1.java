import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class design1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int range = scanner.nextInt();
        IntStream.range(0, range).forEachOrdered(i -> {
            if (scanner.nextInt() == 1) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                stack1.push(scanner.nextInt());
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                System.out.println(stack1.toString());
            } else {
                System.out.println(stack1.isEmpty() ? -1 : stack1.pop());
            }
        });
    }
}
