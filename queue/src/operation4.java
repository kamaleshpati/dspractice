import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

public class operation4 {
    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> s = new Stack<>();
    static int count = 0;

    public static void main(String[] args) {
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        interLeaveQueue(q.size());
        System.out.println(q);
    }

    private static void interLeaveQueue(int size) {
        stcakify(size);
        IntStream.range(0, size / 2).forEachOrdered(i -> {
            q.add(s.pop());
            q.add(q.poll());
        });
    }

    private static void stcakify(int size) {
        if (count == size / 2)
            return;
        count++;
        int num = q.poll();
        stcakify(size);
        s.push(num);
        return;
    }
}
