public class RotateImage {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        RotateImage instance = new RotateImage();
        instance.output(a);
        instance.rotate(a);
        instance.output(a);
    }

    public void output(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int a = 0;
        int b = matrix.length - 1;
        while (a <= b) {
            int[] p = matrix[a];
            matrix[a] = matrix[b];
            matrix[b] = p;
            a++;
            b--;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
