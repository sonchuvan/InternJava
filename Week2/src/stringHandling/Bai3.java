package stringHandling;

import java.util.Locale;
import java.util.Scanner;

public class Bai3 {
    static String standardizeString(String[] s){
        String temp="";
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].substring(0, 1).toUpperCase(Locale.ROOT) + s[i].substring(1);
            temp += s[i];
            if (i != s.length - 1) temp += " ";
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập xâu:");
        String s = in.nextLine().trim().toLowerCase(Locale.ROOT);
        while (s.contains("  ")) s = s.replaceAll("  ", " ");
        s = standardizeString(s.split(" "));
        System.out.println(s);
    }
}
