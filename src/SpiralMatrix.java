import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * 
 * @author yishen
 * 
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] data = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix instance = new SpiralMatrix();
        instance.spiralOrder(data);
        System.out.println(instance.result);
    }

    private List<Integer> result = new ArrayList<Integer>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        int total = matrix.length * matrix[0].length;

        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        while (i < total) {
            while (k < right && i < total) {
                result.add(matrix[j][k]);
                i++;
                k++;
            }

            k--;
            j++;
            top++;

            while (j < bottom && i < total) {
                result.add(matrix[j][k]);
                i++;
                j++;
            }

            k--;
            j--;
            right--;

            while (k >= left && i < total) {
                result.add(matrix[j][k]);
                i++;
                k--;
            }

            k++;
            j--;
            bottom--;

            while (j >= top && i < total) {
                result.add(matrix[j][k]);
                i++;
                j--;
            }

            j++;
            k++;
            left++;
        }
        return result;
    }
}
