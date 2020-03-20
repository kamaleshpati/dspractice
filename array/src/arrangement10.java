import java.util.Arrays;
import java.util.Scanner;

public class arrangement10 {
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
            pushOddEven(testcase[i]);
        }
    }

    private static void pushOddEven(int[] ints) {
        Arrays.sort(ints);
        int ans[] = new int[ints.length];
        int p = 0, q = ints.length - 1;
        for (int i = 0; i < ints.length; i++) {
            if ((i + 1) % 2 == 0)
                ans[i] = ints[q--];
            else
                ans[i] = ints[p++];
        }
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
