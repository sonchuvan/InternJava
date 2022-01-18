package array;

import java.util.Scanner;

public class Bai5 {
    static Scanner in = new Scanner(System.in);

    static int[] input() {
        System.out.print("Nhập n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập arr[" + i + "]");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    static int[] insert(int[] a,int[] b, int p){
        int z = a.length+b.length;
        int[] c = new int[z];
        int z1 = p;
        int z2 = p+b.length;
        int j = 0;
        for (int i = 0; i < z; i++) {
            if (i<z1){
                c[i] = a[i];
            }
            else if(i>=z1 && i < z2){
                c[i] = b[j];
                j++;
            }
            else {
                c[i] = a[i-p+1];
            }
        }
        return c;
    }

    static void output(int[] arr) {
        System.out.println("Kết quả:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = input();
        int[] b = input();
        System.out.print("Nhập p:");
        int p = in.nextInt();
        int[] c = insert(a,b,p);
        output(c);
    }
}
