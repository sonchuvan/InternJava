package stringHandling;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập xâu:");
        StringBuilder str = new StringBuilder(in.next());
        for (int i = 0; i < str.length(); i += 2) {
            str.setCharAt(i,str.substring(i,i+1).toUpperCase().charAt(0));
        }
        System.out.println(str);
    }
}
