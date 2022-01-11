package array;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("nhap n:");
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if(a[i]!=a[n-i-1]) {
                System.out.println("mang khong doi xung");
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("mang doi xung");
    }
}
