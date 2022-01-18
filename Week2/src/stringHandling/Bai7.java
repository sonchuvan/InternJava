package stringHandling;

import java.util.Scanner;

public class Bai7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = "";
        do {
            System.out.println("Nhập xâu s1:");
            s1 = in.nextLine().trim();
        }while (s1.equals(""));
        String s2 = "";
        do {
            System.out.println("Nhập xâu s2:");
            s2 = in.nextLine().trim();
        }while (s2.equals(""));
        while (s1.contains(s2)) s1 = s1.replaceAll(s2,"");
        System.out.println(s1);
    }

}
