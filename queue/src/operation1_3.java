import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

public class operation1_3 {
    static Queue<Integer> queue;
    static int count = 0;

    static void reverseQueue() {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }

    static Queue<Integer> reverseQueueRecursive() {
        if (queue.isEmpty())
            return queue;
        int data = queue.remove();
        queue = reverseQueueRecursive();
        queue.add(data);
        return queue;
    }

    static void reverseQueueRecursiveK(int size) {
        if (count == size)
            return;
        count++;
        int data = queue.remove();
        reverseQueueRecursiveK(size);
        queue.add(data);
        return;
    }

    static void reverseQueueRecursive(int size) {
        reverseQueueRecursiveK(size);
        int bound = queue.size() - size;
        IntStream.range(0, bound)
                .forEachOrdered(i -> queue.add(queue.poll()));
    }

    public static void main(String args[]) {
        queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
        System.out.println(queue);
//        reverseQueue();
//        System.out.println(queue);
//        reverseQueueRecursive();
//        System.out.println(queue);
        reverseQueueRecursive(5);
        System.out.println(queue);

    }
}
