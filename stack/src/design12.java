import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class design12 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(new ArrayList<>(deque));
    }
}
