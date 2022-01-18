package array;

import java.util.Scanner;

public class Bai7 {
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

    static void search(int[] a) {
        int max = 0;
        //int temp = 0;
        int flag = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int dem = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (temp < a[j]) {
                    dem++;
                    temp = a[j];
                } else break;
            }
            if (max < dem) {
                max = dem;
                flag = i;
            }
        }
        System.out.println("\nĐường chạy dài nhất ở vị trí " + flag + " có độ dài: " + max);
    }

    static void output(int[] arr) {
        System.out.println("Kết quả:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = input();
        output(a);
        search(a);
    }
}
