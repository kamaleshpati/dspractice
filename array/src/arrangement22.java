import java.util.Scanner;

public class arrangement22 {
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
            for (int j = 0; j < testcase[i].length; j++)
                System.out.print(testcase[i][j] + " ");
            System.out.println();
        }
    }

    private static void pushOddEven(int[] arr) {
        int even = 0, odd = 1, temp;
        int size = arr.length;
        while (true) {
            while (even < size && arr[even] >= 0)
                even += 2;
            while (odd < size && arr[odd] <= 0)
                odd += 2;
            if (even < size && odd < size) {
                temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
            } else
                break;
        }
    }
}
