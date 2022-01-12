package array;

import java.util.Scanner;

public class tet {
    static  Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử của mảng: ");
        int n = scanner.nextInt();
        int a[] = new int [n];
        int b[] = new int [n];
        nhapMang(a);
        duongChay(a);
    }
    public static void nhapMang(int a[])
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print("a["+i+"] = ");
            a[i] = scanner.nextInt();
        }
    }
    public static void xuatMang(int a[],int b[])
    {
        int max = 0;
        for (int i = 0; i< b.length;i++)
        {
            if(b[i]>max) {
                max = b[i];
            }
        }
        System.out.println("Mảng vừa nhập là:");
        for (int x:a)
        {
            System.out.print(x+" ");
        }
        int vtri = 0;
        for(int x:b)
        {
            if(x == max)
            {
                System.out.println("Vị trí : "+vtri+", độ dài: "+(max));
            }
            vtri+=x;
        }
    }
    public static void duongChay(int[] a)
    {
        int index = 0;
        int []b = new int[a.length];
        for(int i=0; i< a.length;i++)
        {
            if(i == a.length-1){
                b[index]++;
                break;
            }
            if(a[i] > a[i+1])
            {
                b[index]++;
                index++;
            }
            else {
                b[index]++;
            }
        }
        xuatMang(a,b);

    }
}
