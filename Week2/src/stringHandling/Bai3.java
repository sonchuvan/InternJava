package stringHandling;

import java.util.Locale;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập xâu:");
        //String s = in.nextLine();
        String s = "  chu    vAN   son  ";
        s = s.trim().toLowerCase(Locale.ROOT);
        while (s.contains("  ")) s = s.replaceAll("  ", " ");
        String[] sa = s.split(" ");
        s = "";
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sa[i].substring(0, 1).toUpperCase(Locale.ROOT) + sa[i].substring(1);
            s += sa[i];
            if (i != sa.length - 1) s += " ";
        }
        System.out.println(s);

    }
}
