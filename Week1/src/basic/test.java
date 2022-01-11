package basic;

import java.util.Scanner;

public class test {
    public test() {
    }

    public static int fibo(int n) {
        int c = 0;
        int a = 0;
        int b = 1;

        for(int i = 2; i <= n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static boolean ktfibo(int n) {
        for(int i = 1; i <= 10; ++i) {
            if (n == fibo(i)) {
                return true;
            }
        }

        return false;
    }

    public static int tong(int n) {
        int s;
        for(s = 0; n > 0; n /= 10) {
            s += n % 10;
        }

        return s;
    }

    public static void main(String[] args) {
        new Scanner(System.in);
        System.out.println("cac so co 5 den 7 chu so ma tong cac chu so la 1 so trong day fibo la: ");

        for(int i = 10000; i <= 9999999; ++i) {
            if (ktfibo(tong(i))) {
                System.out.println(i);
            }
        }

    }
}