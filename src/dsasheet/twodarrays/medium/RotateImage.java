package dsasheet.twodarrays.medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int it = matrix.length/2 - 1;
        int n = matrix.length - 1;
        for (int fixed = 0; fixed <= it; fixed++) {
            for (int var = fixed; var < (n-fixed); var++) {
                int temp = matrix[fixed][var];
                matrix[fixed][var] = matrix[n-var][fixed];
                matrix[n-var][fixed] = matrix[n-fixed][n-var];
                matrix[n-fixed][n-var] = matrix[var][n-fixed];
                matrix[var][n-fixed] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
       //transpose
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reflect

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
