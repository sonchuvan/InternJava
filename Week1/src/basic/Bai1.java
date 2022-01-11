package basic;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("nhap n:");
        int n = in.nextInt();
        float s = 0;
        if(n%2!=0){
            for(int i=1;i<=n;i+=2){
                s+=i;
            }
        }
        else{
            for(int i=0;i<=n;i+=2){
                s+=i;
            }
        }
        System.out.println("a: s = "+s);
        //bai 1 y b
        s=0;
        for(int i=1;i<=n;i++){
            s += (float)1/i;
        }
        System.out.println("b: s = "+s);
    }
}
