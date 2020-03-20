import java.util.Scanner;

public class optimization6 {
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
            System.out.println(minJump(testcase[i]));
        }
    }

    private static int minJump(int[] ints) {
        int steps = 1;
        for (int i = ints[0]; i < ints.length - 1; i = i + ints[i]) {
            steps++;
            System.out.print(ints[i]);
        }
        return steps;
    }
}