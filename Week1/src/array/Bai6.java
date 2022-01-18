package array;

import java.util.Scanner;

public class Bai6 {
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

    static int[] insert(int[] arr, float k) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > k) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = (int) k;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

    static void output(int[] arr) {
        System.out.println("Kết quả:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = input();
        System.out.println("Nhập x");
        float x = in.nextFloat();
        a = sortArray(a);
        a = insert(a, x);
        output(a);
    }
}
