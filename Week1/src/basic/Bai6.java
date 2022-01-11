package basic;

import java.util.Scanner;

public class Bai6 {
    static boolean ktnt(int a){
        for (int i = 2; i < a; i++) {
            if(a%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.print("nhap n:");
        int n = in.nextInt();
        System.out.print(n+" = ");
        if(ktnt(n)) System.out.println(n);
        else {
            while (n>1){
                for (int i = 2 ; i <= n; i++) {
                    if(n%i==0 && ktnt(i)) {
                        n = n / i;
                        if(n ==1 ) System.out.print(i + " ");
                        else System.out.print(i + "x");
                        break;
                    }
                }
            }
        }
    }
}
