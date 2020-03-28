import java.util.LinkedList;
import java.util.Queue;

public class impl6 {
    Queue<Integer> q = new LinkedList<Integer>();

    void push(int val) {
        int size = q.size();
        q.add(val);
        for (int i = 0; i < size; i++) {
            int x = q.remove();
            q.add(x);
        }
    }

    int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    public static void main(String[] args) {
        impl6 s = new impl6();
        s.push(10);
        System.out.println(s.q);
        s.push(20);
        System.out.println(s.q);
        s.pop();
        System.out.println(s.q);
        s.push(30);
        System.out.println(s.q);
        s.pop();
        System.out.println(s.q);
    }
}
