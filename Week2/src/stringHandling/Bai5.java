package stringHandling;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        //String str = "chu...van...son";
        String patern2 = "\\w+[.]{3}\\w+[.]{3}\\w+";
        while (!Pattern.matches(patern2,str)){
            System.out.println("Chưa đúng định dạng, nhập lại.");
            str = in.nextLine();
        }
        String temp = str.substring(str.lastIndexOf("..."));
        str = str.substring(0,str.lastIndexOf("..."));
        str =temp.substring(temp.lastIndexOf(".")+1)+"..."+str;
        System.out.println(str);
    }
}
