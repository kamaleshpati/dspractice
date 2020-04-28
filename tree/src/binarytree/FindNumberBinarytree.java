package binarytree;

public class FindNumberBinarytree {
    public static void main(String[] args) {
        findNumberOfBinary(4);
        findNumberOfBinaryMath(4);
    }

    private static void findNumberOfBinaryMath(int i) {
        System.out.println(fact(2*i)/(fact(i+1)*fact(i)));
    }

    private static int fact(int i) {
        if(i==1){
            return 1;
        }
        else{
            return i*fact(i-1);
        }
    }

    private static void findNumberOfBinary(int n) {
        int BT[] = new int[n + 1];
        BT[0] = BT[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; j++) {
                System.out.println(i+" "+j+" "+BT[j]+" "+BT[i - j - 1]);
                BT[i] += BT[j] * BT[i - j - 1];
            }
        }

        System.out.println(BT[n]);
    }
}
