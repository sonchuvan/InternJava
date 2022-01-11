package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {
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
        a = sort(a);
        int max = 0;
        int temp = a[0];
        for (int i = 0; i < n; i++) {
            int dem=1;
            for (int j = i+1; j < n ; j++) {
                if (a[i]==a[j]){
                    dem++;
                    i++;
                    if(dem>max){
                        max=dem;
                        temp = a[i];
                    }
                }else break;
            }
            System.out.println(a[i]+" xuat hien "+ dem+" lan");
        }
        System.out.println(temp+" xuat hien nhieu nhat voi "+ max+" lan");
    }
}
