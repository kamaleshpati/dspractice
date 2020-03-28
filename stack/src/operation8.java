import java.util.LinkedList;
import java.util.Queue;

public class operation8 {
    static Queue<Integer> queue = new LinkedList<>();

    static boolean checkSorted(Queue<Integer> q) {
        return false;
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        if (checkSorted(q))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
