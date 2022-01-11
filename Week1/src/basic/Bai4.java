package basic;

import java.util.Scanner;

public class Bai4 {
    static int ucln(int a, int b){
        int uc = 0;
        for(int i = 1; i <= a && i <= b; i++){
            if(a%i==0 && b%i==0){
                uc = i;
            }
        }
        return uc;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("nhap a:");
        int a = in.nextInt();
        System.out.println("nhap b:");
        int b = in.nextInt();
        if(a >b){
            a = b+(a-(b=a));
        }
        System.out.println("cac cap so NT cung nhau: ");
        for (int i = a; i <= b; i++) {
            for (int j = i+1; j <= b; j++) {
                if(ucln(i,j)==1){
                    System.out.println(i+ " "+j);
                }
            }
        }

    }
}
