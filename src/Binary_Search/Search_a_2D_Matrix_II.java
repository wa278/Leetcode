package Binary_Search;

public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (target < matrix[i][j])
                j--;
            else if (target > matrix[i][j])
                i++;
            else
                return true;
        }
        return false;
    }
}
