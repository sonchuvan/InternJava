package stringHandling;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai6 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        String m = "([^ ]{0,10}. ){0,19}.{1,10}";
        String s = in.nextLine();
        s.trim();
        while (s.contains("  ")) s = s.replaceAll("  ", " ");

        while (!Pattern.matches(m,s) || s.compareTo(" ")==0 ){
            System.out.println("Nhập sai định dạng, nhập lại");
            s = in.nextLine();
            s.trim();
            while (s.contains("  ")) s = s.replaceAll("  ", " ");
        }
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if(str[i].compareTo(str[j]) > 0){
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
