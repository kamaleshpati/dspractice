import java.util.Arrays;

public class sort5 {
    public static void main(String[] args) {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        for (int i = 0, j = 0; i < mPlusN.length; i++) {
            if (mPlusN[i] == -1) {
                mPlusN[i] = N[j];
                j++;
            }
        }
        Arrays.sort(mPlusN);
        Arrays.stream(mPlusN).forEachOrdered(System.out::println);
    }
}
