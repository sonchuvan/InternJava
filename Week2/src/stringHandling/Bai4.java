package stringHandling;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println("Nhập xâu:");
        //String s = in.nextLine();
        String s = "  chu  vAN   sonn  ";
        System.out.println(s);
        s = s.trim();
        while (s.contains("  ")) s = s.replaceAll("  ", " ");
        String[] sa = s.split(" ");
        String temp = sa[0];
        int vt = 0;
        for (int i = 0; i < sa.length; i++) {

            if(temp.length()<sa[i].length()){
                temp = sa[i];
                vt = i;
            }
        }
        System.out.println("từ dài nhất: "+temp+", vị trí "+vt);
    }
}
