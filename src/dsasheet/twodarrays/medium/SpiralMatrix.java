package dsasheet.twodarrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowMin = 0;
        int rowMax = matrix.length-1;
        int colMin = 0;
        int colMax = matrix[0].length-1;
        while (rowMin<=rowMax && colMin<=colMax) {
            for (int i = colMin; i <= colMax; i++) {
                list.add(matrix[rowMin][i]);
            }

            for (int i = rowMin+1; i <= rowMax; i++) {
                list.add(matrix[i][colMax]);
            }

            if(rowMin!=rowMax) {
                for (int i = colMax - 1; i >= colMin; i--) {
                    list.add(matrix[rowMax][i]);
                }
            }

            if (colMin!=colMax) {
                for (int i = rowMax - 1; i > rowMin; i--) {
                    list.add(matrix[i][colMin]);
                }
            }
            rowMin++;
            rowMax--;
            colMin++;
            colMax--;
        }
        return list;
    }
}
