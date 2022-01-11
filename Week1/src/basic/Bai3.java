package basic;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("nhap a:");
        int a = in.nextInt();
        System.out.println("nhap b:");
        int b = in.nextInt();
        int ucln = 0;
        int bcnn = 0;
        for(int i = 1; i <= a && i <= b; i++){
            if(a%i==0 && b%i==0){
                ucln = i;
            }
        }
        System.out.println("UCLN: "+ucln);
        int temp = a;
        while ( bcnn == 0){
            if(temp % a == 0 && temp % b == 0){
                bcnn = temp;
            }
            temp++;
        }
        System.out.println("BCNN: "+bcnn);
    }
}
