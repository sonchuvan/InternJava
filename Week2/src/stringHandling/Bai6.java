package stringHandling;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai6 {
    static String[] sortStringArray(String[] str){
        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if(str[i].compareTo(str[j]) > 0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        String m = "([^ ]{0,10}. ){0,19}.{1,10}";
        String s ;
        do{
            System.out.println("Nhập Xâu:");
            s = in.nextLine().trim();
            while (s.contains("  ")) s = s.replaceAll("  ", " ");
        }while (!Pattern.matches(m,s) || s.compareTo(" ")==0 );
        String[] str = s.split(" ");
        str  = sortStringArray(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
