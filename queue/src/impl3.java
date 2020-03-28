import java.util.Deque;
import java.util.LinkedList;

public class impl3 {
    Deque<Integer> deque = new LinkedList<>();

    void push(int item) {
        deque.add(item);
        System.out.println(deque);
    }

    int pop() {
        return deque.pollLast();
    }

    public static void main(String[] args) {
        impl3 impl3 = new impl3();
        impl3.push(1);
        impl3.push(2);
        impl3.push(3);
        impl3.push(4);
        impl3.push(5);
        impl3.push(6);
        impl3.push(7);
        System.out.println(impl3.pop() + "     "+impl3.deque);
        System.out.println(impl3.pop() + "     "+impl3.deque);
        System.out.println(impl3.pop() + "     "+impl3.deque);
        System.out.println(impl3.pop() + "     "+impl3.deque);
        System.out.println(impl3.pop() + "     "+impl3.deque);
    }
}
