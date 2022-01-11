package array;

import java.util.Scanner;

public class Bai5 {
    static Scanner in = new Scanner(System.in);
    static int[] input(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
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
    public static void main(String[] args) {
        System.out.print("nhap n:");
        int n = in.nextInt();
        int[] a = input(n);
        System.out.print("nhap m:");
        int m = in.nextInt();
        int[] b = input(m);
        System.out.print("nhap p:");
        int p = in.nextInt();

        int[] c = insert(a,b,p);
        for (int i = 0; i < m + n; i++) {
            System.out.print(c[i]+" ");
        }
    }
}
