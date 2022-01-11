package array;

import java.util.Scanner;

public class Bai4 {
    static Scanner in = new Scanner(System.in);
    static int[] sort(int a[]){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    static boolean ktnt(int n){
        if (n<2) return false;
        if (n==2 ) return true;
        if(n>2){
            for (int i = 2; i <= n/2; i++) {
                if( n % i == 0 ) return false;
            }
        }
        return true;
    }
    static int[] input(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.print("nhap n:");
        int n = in.nextInt();
        int[] a = input(n);
        System.out.println("nhap x");
        int x = in.nextInt();
        int min = -1;
        int temp = 0;
        for(int i=0;i<n;i++){
            if(ktnt(a[i])){
                if(min ==-1) min = Math.abs(x-a[i]);
                else if(min > Math.abs(x-a[i])){
                    min = Math.abs(x-a[i]);
                    temp = a[i];
                }
            }
        }
        System.out.println("so nguyen to gan nhat: "+temp);
    }
}
