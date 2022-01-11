package basic;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("nhap n:");
        int n = in.nextInt();
        int dem = 0;
        System.out.println("cac uoc cua "+n+" la:");
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                System.out.print(i+"  ");
                dem++;
            }
        }
        System.out.println("\nso luong uoc cua "+n+" la: "+dem);
    }
}
