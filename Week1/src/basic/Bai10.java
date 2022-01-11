package basic;

public class Bai10 {
    static boolean ktnt(int n){
        if (n<2) return false;
        if (n==2 ) return true;
        if(n>2){
            for (int i = 2; i <= n/2; i++) {
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
        for (int i = 0; i < 7; i++) {
            if (ktnt(arr[i])==false) return false;
        }
        return true;
    }
    static boolean check(int n){
        int reversed = 0;
        while(n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        if(ktnt(reversed)) return true;
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1000001; i < 9999999; i+=2) {
            if(ktnt(i))
                if(ktcs(i))
                    if(check(i)) System.out.println(i);
            System.out.println("a");
        }
    }
}
