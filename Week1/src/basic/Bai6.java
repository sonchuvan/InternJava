package basic;

import java.util.Scanner;

public class Bai6 {
    static boolean checkPrimeNumber(int a) {
        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("nhap n:");
        int n = in.nextInt();
        System.out.print(n + " = ");
        if (checkPrimeNumber(n)) System.out.println(n);
        else {
            int i = 2;
            while (n > 1) {
                if (n % i == 0 ) {
                    n = n / i;
                    if(n==1) System.out.println(i);
                    else System.out.print(i + "x");
                }
                else {
                    i++;
                }
            }
        }
    }
}
