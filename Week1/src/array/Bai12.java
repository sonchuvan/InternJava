package array;

public class Bai12 {
    static void xoay(int[][] a){
        int[][] b = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j<a.length; j++) {
                b[i][j]=a[j][a.length-1-i];
            }
        }
        print(b);
    }
    static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("Show the matrix:");
        xoay(a);
    }
}
