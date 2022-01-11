package basic;

public class Bai10 {
    static boolean ktnt(int n){
        if (n<2) return false;
        if (n==2 ) return true;
        if(n>2){
            for (int i = 2; i <= n/2; i+=2) {
                if( n % i == 0 ) return false;
            }
        }
        return true;
    }

    static int[] convertToArr(int n){
        int[] arr = new int[7];
        int i=0;
        while (n>0){
            arr[i] = n%10;
            i++;
            n=n/10;
        }
        return arr;
    }
    static boolean ktcs(int n){
        int[] arr = convertToArr(n);
        int s = 0;
        for (int i = 0; i <7; i++) {
            s = (int) (s + (Math.pow(10, 6 - i)) * arr[i]);
        }
        for (int i = 0; i < 7; i++) {
            if (!ktnt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1000001; i < 9999999; i+=2) {
            if(ktnt(i)){
                if(ktcs(i)) System.out.println(i);
            }
        }
    }
}
