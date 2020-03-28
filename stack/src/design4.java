import java.util.LinkedList;
import java.util.Queue;

public class design4 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int pop() {
        if(q1.size()==0)
            return -1;
        return q1.remove();
    }
    void push(int a) {
        q2.add(a);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public static void main(String[] args) {
        design4 test = new design4();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
    }
}
