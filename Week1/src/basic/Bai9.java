package basic;

public class Bai9 {

    static boolean checkInverseNumber(int n) {
        int temp = n, res = 0;
        while (n > 0) {
            //temp = ;
            res = res * 10 + n % 10;
            n = n / 10;
        }
        if (res != temp) return false;
        return true;
    }

    static boolean checkDivisible10(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        if (sum % 10 != 0) return false;
        return true;
    }

    static boolean checkNumber068(int n) {
        int dem = 0;
        while (n > 0) {
            if ((n % 10) % 2 == 0 && n % 10 != 2 && n % 10 != 4 ) {
                dem++;
            }
            n = n/10;
        }
        if(dem == 7) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("cac so thuan nghich co 7 chu so:");
        for (int i = 1000000; i <= 9999999; i++) {
            if (checkInverseNumber(i) && checkDivisible10(i) && checkNumber068(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
