package array;

public class Bai9 {
    static void sort(int[][] a) {

        int row = a.length;
        int col = a[1].length;
        int size = row * col;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (a[j / col][j % col] > a[(j + 1) / col][(j + 1) % col]) {
                    int temp = a[j / col][j % col];
                    a[j / col][j % col] = a[(j + 1) / col][(j + 1) % col];
                    a[(j + 1) / col][(j + 1) % col] = temp;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 7, 3}, {4, 8, 6}, {5, 9, 2}};
        System.out.println("Show the matrix:");
        sort(a);
    }
}
