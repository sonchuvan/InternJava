package array;

import java.util.Scanner;

public class Bai3 {
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
    static void countNumber(int[] a){
        int max = 1;
        int temp = a[0];
        for (int i = 0; i < a.length; i++) {
            int dem=1;
            for (int j = i+1; j < a.length ; j++) {
                if (a[i]==a[j]){
                    dem++;
                    i++;
                    if(dem>max){
                        max=dem;
                        temp = a[i];
                    }
                }else break;
            }
            System.out.println(a[i]+" xuất hiện "+ dem+" lần");
        }
        System.out.println(temp+" xuất hiện nhiều nhất "+ max+" lần");
    }

    public static void main(String[] args) {

        int[] arr = input();
        arr = sortArray(arr);
        countNumber(arr);
    }
}
