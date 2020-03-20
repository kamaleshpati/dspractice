import java.util.Scanner;

public class arrangement6 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int testcaseNum = scanner.nextInt();
        int[][] testcase = new int[testcaseNum][];
        for (int i = 0; i <testcaseNum ; i++) {
            int size = scanner.nextInt();
            testcase[i]=new int[size];
            for (int j = 0; j < size; j++) {
                testcase[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i < testcaseNum; i++) {
            pushZero(testcase[i]);

        }
    }

    private static void pushZero(int[] arr) {
//        int pos = -1;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                pos = i;
//                while (arr[i] == 0 && i < arr.length - 1) {
//                    i++;
//                }
//                arr[pos] = arr[i];
//                arr[i] = 0;
//                i = pos;
//            }
//        }
        int count = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] != 0)) {
                temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count = count + 1;
            }
        }
    }
}
