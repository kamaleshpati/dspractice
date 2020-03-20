import java.util.Arrays;
import java.util.Scanner;

public class sort2 {
    static void insertionSort(int[] arr) {
        int size = arr.length;
        int i, key, j;
        for (i = 1; i < size; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            Arrays.stream(arr).forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
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
            insertionSort(testcase[i]);
            for (int j = 0; j < testcase[i].length; j++)
                System.out.print(testcase[i][j] + " ");
            System.out.println();
        }
    }
}
