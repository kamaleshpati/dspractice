import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
    static ArrayList<ArrayList<Integer>>
    combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans
                = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, sum, 0, temp);
        return ans;
    }

    static void
    findNumbers(ArrayList<ArrayList<Integer>> ans,
                ArrayList<Integer> arr, int sum, int index,
                ArrayList<Integer> temp) {

        if (sum == 0) {


            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {


            if ((sum - arr.get(i)) >= 0) {


                temp.add(arr.get(i));

                findNumbers(ans, arr, sum - arr.get(i), i,
                        temp);

                temp.remove(arr.get(i));
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);

        int sum = 8;

        ArrayList<ArrayList<Integer>> ans
                = combinationSum(arr, sum);

        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }


        for (ArrayList<Integer> an : ans) {

            System.out.print("(");
            an.stream().map(integer -> integer + " ").forEachOrdered(System.out::print);
            System.out.print(") ");
        }
    }
}
