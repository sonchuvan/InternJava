package basic;

public class Bai8 {
    static boolean checkInverseNumber(int n){
        int temp =n, res = 0;
        while(n>0){
            //temp = ;
            res = res*10 +n%10;
            n = n/10;
        }
        if(res != temp) return false;
        return true;
    }

    static boolean checkDivisible10(int n){
        int sum = 0;
        while (n>0){
            sum = sum+n%10;
            n = n/10;
        }
        if(sum%10!=0) return false;
        return true;
    }

    public static void main(String[] args) {
        //8a
        System.out.println("cac so thuan nghich co 6 chu so:");
        for (int i = 100000; i <= 999999  ; i++) {
            if(checkInverseNumber(i)) System.out.print(i+" ");
        }
        //      8b
        System.out.println("\ncac so thuan nghich co 6 chu so co tong chia het cho 10:");
        for (int i = 100000; i <= 999999  ; i++) {
            if(checkDivisible10(i)&&checkInverseNumber(i)){
                System.out.print(i+" ");
            }
        }
    }
}
