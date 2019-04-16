package Array;

/**
 * Created by wa941 on 2018/5/28. 顺时针九十度相当于对角线对称，之后交换。
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int lo = 0;
        int hi = matrix.length - 1;
        while (hi > lo) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;
            }
            hi--;
            lo++;
        }
    }
}
