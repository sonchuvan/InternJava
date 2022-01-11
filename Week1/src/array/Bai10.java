package array;

public class Bai10 {
    static int sumx(int[][] a){
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(i == j){
                    s +=a[i][j];
                }
                if(i + j ==a.length-1){
                    s+=a[i][j];
                }
            }
        }
        if(a.length%2!=0) s = s - a[a.length/2][a.length/2];
        return s;
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
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("Show the matrix:");
        print(a);
        System.out.println("tong cac phan tu tren duong cheo chinh va phu: "+sumx(a));
        print(b);
        System.out.println("tong cac phan tu tren duong cheo chinh va phu: "+sumx(b));
    }
}
