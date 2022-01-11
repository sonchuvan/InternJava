package array;

import java.util.Scanner;

public class Bai7 {
    static Scanner in = new Scanner(System.in);
    static int[] input(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }
    static void search(int[] a){
        int max = 0;
        //int temp = 0;
        int flag = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int dem = 1;
            for (int j = i+1; j < a.length; j++) {
                if(temp<a[j]){
                    dem++;
                    temp = a[j];
                }else break;
                System.out.println( "dem:"+dem);
            }
            if(max<dem){
                max = dem;
                flag = i;
                System.out.println("flag:"+flag);
            }
        }
        System.out.println("\nduong chay dai nhat o vi tri "+flag+ " co do dai: "+max);
    }

    public static void main(String[] args) {
        System.out.print("nhap n:");
        int n = in.nextInt();
        int[] a = input(n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
        search(a);
    }
}
