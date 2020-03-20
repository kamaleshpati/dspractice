import java.util.Arrays;
import java.util.Scanner;

public class sort19 {
    static int getTrianlesCount(int[] arr) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = arr.length - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcaseNum = scanner.nextInt();
        int[][] testcase = new int[testcaseNum][];
        for (int i = 0; i < testcaseNum; i++) {
            int size = scanner.nextInt();
            testcase[i] = new int[size];
            for (int j = 0; j < size; j++) {
                testcase[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < testcaseNum; i++) {
            System.out.println(getTrianlesCount(testcase[i]));
        }
    }
}
