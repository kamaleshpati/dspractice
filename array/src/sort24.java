import java.util.Arrays;

public class sort24 {
    static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};

    static void merge() {
        while (arr1[arr1.length - 1] >= arr2[0]) {
            int temp = arr1[arr1.length - 1];
            arr1[arr1.length - 1] = arr2[0];
            arr2[0] = temp;
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
            sort(arr1);
            sort(arr2);
        }

    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        merge();
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
