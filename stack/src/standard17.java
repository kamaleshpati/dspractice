public class standard17 {
    public static void main(String args[]) {
        int n = 3;
        towerOfHanoi(n, "start rod", "temp rod", "result rod");
    }

    private static void towerOfHanoi(int n, String start, String temp, String result) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + start + " to rod " + temp);
            return;
        }
        towerOfHanoi(n - 1, start, result, temp);
        System.out.println("Move disk " + n + " from rod " + start + " to rod " + result);
        towerOfHanoi(n - 1, temp, result, start);
    }
}
