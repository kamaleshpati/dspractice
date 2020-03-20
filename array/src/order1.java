import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class order1 {
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 19};
        int k = 2;
        kthSmallest(arr, k);
    }


    private static void kthSmallest(Integer[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2, Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        System.out.println(priorityQueue.peek());
    }
}
