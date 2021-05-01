import java.util.HashMap;

public class MaxZeroSumSubArray {
    static int maxLen(int arr[])
    {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            Integer prev_i = hM.get(sum);

            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else
                hM.put(sum, i);
        }

        return max_len;
    }

    public static void main(String[] arg)
    {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Length of the longest 0 sum subarray is "
                + maxLen(arr));
    }
}
