import java.util.Scanner;

public class sorting10 {
    static int getInvCount(int[] arr)
    {
        int invCount = 0;
        for (int i = 0; i <arr.length ; i++){
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j])
                    invCount++;
            }
        }
        return invCount;
    }
    public static void main(String[] args)
    {
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
            System.out.println(getInvCount(testcase[i]));
        }
    }
}
