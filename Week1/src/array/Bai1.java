package array;

import java.util.Scanner;

public class Bai1 {
    static Scanner in = new Scanner(System.in);

    static int[] input() {
        System.out.print("Nhập n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập a[" + i + "]");
            arr[i] = in.nextInt();
        }
        return arr;
    }

    static boolean checkSymmetry(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = input();
        if (checkSymmetry(arr)) {
            System.out.println("Mảng đối xứng");
        } else {
            System.out.println("Mảng không đối xứng");
        }

    }
}
