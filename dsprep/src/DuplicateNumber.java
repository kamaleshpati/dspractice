import java.util.ArrayList;
import java.util.List;

public class DuplicateNumber {
    public static int repeatedNumber(List<Integer> list) {
        if (list.size() <= 1)
            return -1;

        int slow = list.get(0);
        int fast = list.get(list.get(0));

        while (fast != slow) {
            slow = list.get(slow);
            fast = list.get(list.get(fast));
        }

        slow = 0;
        while (fast != slow) {
            slow = list.get(slow);
            fast = list.get(fast);
        }
        return slow;
    }
    public static void main(String[] args) {
        int arr[] = { 1,2,3,2 };
        List<Integer> l = new ArrayList<>();
        for(int i:arr){
            l.add(i);
        }
        System.out.println(repeatedNumber(l));
    }
}
