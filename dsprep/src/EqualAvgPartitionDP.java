import java.util.Arrays;
import java.util.Vector;

public class EqualAvgPartitionDP {
    static boolean[][][] dp;
    static Vector<Integer> res = new Vector<>();
    static int[] original;
    static int total_size;

    static boolean possible(int index, int curr_sum,
                            int curr_size) {
        if (curr_size == 0)
            return (curr_sum == 0);
        if (index >= total_size)
            return false;

        if (!dp[index][curr_sum][curr_size])
            return false;

        if (curr_sum >= original[index]) {
            res.add(original[index]);

            if (possible(index + 1, curr_sum - original[index],
                    curr_size - 1))
                return true;

            res.remove(res.size() - 1);
        }

        if (possible(index + 1, curr_sum, curr_size))
            return true;

        return dp[index][curr_sum][curr_size] = false;
    }

    static Vector<Vector<Integer>> partition(int[] Vec) {

        Arrays.sort(Vec);
        original = Vec;
        res.clear();

        int total_sum = 0;
        total_size = Vec.length;

        for (int i = 0; i < total_size; ++i)
            total_sum += Vec[i];

        dp = new boolean[original.length][total_sum + 1][total_size];

        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < total_sum + 1; j++)
                for (int k = 0; k < total_size; k++)
                    dp[i][j][k] = true;

        for (int i = 1; i < total_size; i++) {

            if ((total_sum * i) % total_size != 0)
                continue;
            int Sum_of_Set1 = (total_sum * i) / total_size;

            if (possible(0, Sum_of_Set1, i)) {

                int ptr1 = 0, ptr2 = 0;
                Vector<Integer> res1 = res;
                Vector<Integer> res2 = new Vector<>();
                while (ptr1 < Vec.length || ptr2 < res.size()) {
                    if (ptr2 < res.size() &&
                            res.elementAt(ptr2) == Vec[ptr1]) {
                        ptr1++;
                        ptr2++;
                        continue;
                    }
                    res2.add(Vec[ptr1]);
                    ptr1++;
                }

                Vector<Vector<Integer>> ans = new Vector<>();
                ans.add(res1);
                ans.add(res2);
                return ans;
            }
        }

        Vector<Vector<Integer>> ans = new Vector<>();
        return ans;
    }

    static void Print_Partition(Vector<Vector<Integer>> sol) {
        for (int i = 0; i < sol.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < sol.elementAt(i).size(); j++) {
                System.out.print(sol.elementAt(i).elementAt(j));
                if (j != sol.elementAt(i).size() - 1)
                    System.out.print(" ");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        int[] Vec = {1, 7, 15, 29, 11, 9};
        Vector<Vector<Integer>> sol = partition(Vec);

        if (sol.size() > 0)
            Print_Partition(sol);
        else
            System.out.println("-1");
    }
}
