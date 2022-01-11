package basic;

public class Bai8 {
    static int[] convertToArr(int n){
        int[] arr = new int[6];
        int i=0;
        while (n>0){
            arr[i] = n%10;
            i++;
            n=n/10;
        }
        return arr;
    }
    static int sumArr(int[] arr){
        int s = 0;
        for (int i = 0; i < 6; i++) {
            s+= arr[i];
        }
        return s;
    }

    static boolean kt(int n){
        int[] arr = convertToArr(n);
        for (int i = 0; i < 3; i++) {
            if(arr[i] != arr[5-i]) return false;
        }
        return true;
    }

    static boolean kt2(int n){
        int[] arr = convertToArr(n);
        if(sumArr(arr)%10!=0) return false;
        for (int i = 0; i < 3; i++) {
            if(arr[i] != arr[5-i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //8a
        System.out.println("cac so thuan nghich co 6 chu so:");
        for (int i = 100000; i <= 999999  ; i++) {
            if(kt(i)) System.out.print(i+" ");
        }
        //8b
        System.out.println("\ncac so thuan nghich co 6 chu so co tong chia het cho 10:");
        for (int i = 100000; i <= 999999  ; i++) {
            if(kt2(i)){
                System.out.print(i+" ");
            }
        }
    }
}
