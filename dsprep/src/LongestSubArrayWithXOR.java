import java.util.HashMap;

public class LongestSubArrayWithXOR {
    static long subarrayXor(int arr[], int n, int m) {
        long ans = 0;
        int[] xorArr = new int[n];
        HashMap<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        xorArr[0] = arr[0];

        for (int i = 1; i < n; i++)
            xorArr[i] = xorArr[i - 1] ^ arr[i];

        for (int i = 0; i < n; i++) {
            int tmp = m ^ xorArr[i];

            ans = ans
                    + (!mp.containsKey(tmp)
                    ? 0
                    : ((long) mp.get(tmp)));

            if (xorArr[i] == m)
                ans++;

            if (mp.containsKey(xorArr[i]))
                mp.put(xorArr[i], mp.get(xorArr[i]) + 1);
            else
                mp.put(xorArr[i], 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int n = arr.length;
        int m = 6;

        System.out.print(
                "Number of subarrays having given XOR is "
                        + subarrayXor(arr, n, m));
    }
}
