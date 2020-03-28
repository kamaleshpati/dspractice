import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class design10 {
    static int count = 0;

    static class PQ implements Comparable<PQ> {
        private int item;
        int count;

        PQ(int item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public int compareTo(PQ o) {
            return o.count<this.count?-1:1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<PQ> pqPriorityQueue = new PriorityQueue<>();
        pqPriorityQueue.add(new PQ(1, count++));
        pqPriorityQueue.add(new PQ(2, count++));
        pqPriorityQueue.add(new PQ(3, count++));
        IntStream.range(0, pqPriorityQueue.size()).forEachOrdered(i -> {
            System.out.println(pqPriorityQueue.remove().item);
        });
    }
}
