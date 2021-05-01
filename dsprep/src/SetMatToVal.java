import java.util.Arrays;
import java.util.stream.IntStream;

public class SetMatToVal {
    public static void modifyMatrix(int[][] mat){

        boolean row_flag = false;
        boolean col_flag = false;

        for (int i = 0; i < mat.length; i++ ){
            for (int j = 0; j < mat[0].length; j++){
                if (i == 0 && mat[i][j] == 1)
                    row_flag = true;

                if (j == 0 && mat[i][j] == 1)
                    col_flag = true;

                if (mat[i][j] == 1){

                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }

            }
        }

        for (int i = 1; i < mat.length; i ++){
            for (int j = 1; j < mat[0].length; j ++){

                if (mat[0][j] == 1 || mat[i][0] == 1){
                    mat[i][j] = 1;
                }
            }
        }

        if (row_flag){
            Arrays.fill(mat[0], 1);
        }

        if (col_flag){
            IntStream.range(0, mat.length).forEachOrdered(i -> mat[i][0] = 1);
        }
    }
    public static void printMatrix(int[][] mat, int R, int C) {
        int i, j;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},};

        System.out.println("Matrix Intially");

        printMatrix(mat, 3, 4);

        modifyMatrix(mat);
        System.out.println("Matrix after modification n");
        printMatrix(mat, 3, 4);

    }

}
