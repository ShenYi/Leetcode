public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new UniqueBinarySearchTrees().numTrees(5));
    }

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int start = 1;
        for (int i = 2; i <= n; i++) {
            start = start * (4 * i - 2) / (i + 1);
        }
        return start;
    }

}
