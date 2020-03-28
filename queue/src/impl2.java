import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class impl2 {
    Deque<Integer> deque;
    List<Integer> list;
    int size;

    impl2(int size) {
        this.size = size;
        deque = new LinkedList<>();
        list = new LinkedList<>();
    }

    void enq(int item) {
        if (list.contains(item)) {
            if (deque.contains(item))
                deque.remove(item);
            deque.addLast(item);
        } else {
            list.add(item);
            deque.add(item);
        }
        while (list.size() > size) {
            list.remove(deque.poll());
        }
    }

    public static void main(String[] args) {
        impl2 impl2 = new impl2(3);
        impl2.enq(1);
        System.out.println(impl2.deque);
        impl2.enq(2);
        System.out.println(impl2.deque);
        impl2.enq(1);
        System.out.println(impl2.deque);
        impl2.enq(3);
        System.out.println(impl2.deque);
        impl2.enq(1);
        System.out.println(impl2.deque);
        impl2.enq(4);
        System.out.println(impl2.deque);
        impl2.enq(5);
        System.out.println(impl2.deque);
        impl2.enq(6);
        System.out.println(impl2.deque);
        impl2.enq(7);
        System.out.println(impl2.deque);
    }

}
