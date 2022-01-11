package array;

public class Bai11 {
    static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int sumRow(int[] a){
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s+=a[i];
        }
        return s;
    }
    static int[][] search(int[][] a){
        int flag = 0;
        int sum = 0;
        int min = sumRow(a[0]);
        for (int i = 1; i < a.length; i++) {
            if(sumRow(a[i]) < min){
                min = sumRow(a[i]);
                flag = i;
            }
        }
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(flag == i){
                continue;
            }
            a[j] = a[i];
            j++;
        }
        return a;
    }
    public static void main(String[] args) {
        int[][] a = {{5,6,7,8},{1,2,3,4},{9,10,11,12},{13,14,15,16}};
        System.out.println("Show the matrix:");
        print(a);
        System.out.println("xoa dong tong nho nhat: ");
        print(search(a));

    }
}
