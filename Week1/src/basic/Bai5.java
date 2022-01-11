package basic;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("nhap n:");
        int n = in.nextInt();
        int s = 0;
        while (n>0){
            s += n%10;
            n = n/10;
        }
        System.out.println("tong cac so: "+ s);
    }
}
