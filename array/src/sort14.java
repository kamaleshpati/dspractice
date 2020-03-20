import java.util.HashMap;
import java.util.Scanner;

public class sort14 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testcaseNum = scanner.nextInt();
        int[][] testcase = new int[testcaseNum][];
        int[][] testcase1 = new int[testcaseNum][];
        for (int i = 0; i < testcaseNum; i++) {
            int testcaseSize = scanner.nextInt();
            int testcase1Size = scanner.nextInt();
            testcase[i] = new int[testcaseSize];
            for (int j = 0; j < testcaseSize; j++) {
                testcase[i][j] = scanner.nextInt();
            }
            testcase1[i] = new int[testcase1Size];
            for (int j = 0; j < testcase1Size; j++) {
                testcase1[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < testcaseNum; i++) {
            System.out.println(UnionArray(testcase[i], testcase1[i]));
        }
    }

    private static int UnionArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
           hashMap.put(arr1[i],0);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hashMap.containsKey(arr2[i]))
                hashMap.put(arr2[i],0);
        }
        return hashMap.size();
    }

}
