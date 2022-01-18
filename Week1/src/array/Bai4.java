package array;

import java.util.Scanner;

public class Bai4 {
    static Scanner in = new Scanner(System.in);

    static int[] input() {
        System.out.print("Nhập n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập arr[" + i + "]");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    static boolean checkPrimeNumber(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void nearestPrime(int[] a,int x){
        int min = -1;
        int temp = 0;
        for(int i=0;i<a.length;i++){
            if(checkPrimeNumber(a[i])){
                if(min ==-1) min = Math.abs(x-a[i]);
                else if(min > Math.abs(x-a[i])){
                    min = Math.abs(x-a[i]);
                    temp = a[i];
                }
            }
        }
        System.out.println("Số nguyên tố gần nhất: "+temp);
    }

    public static void main(String[] args) {

        int[] a = input();
        System.out.println("Nhập x");
        int x = in.nextInt();
        nearestPrime(a,x);
    }
}
