package basic;

public class Bai10 {
    static boolean checkPrimeNumber(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean checkNumberPrime(int n) {
        while (n > 0) {
            if (!checkPrimeNumber(n % 10)) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    static boolean checkInverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }
        return checkPrimeNumber(reversed);
    }

    public static void main(String[] args) {
        System.out.println("Kết quả:");

        for (int i = 1000001; i < 9999999; i += 2) {
            if (checkPrimeNumber(i) && checkNumberPrime(i) && checkInverseNumber(i))
                System.out.println(i);
        }
    }
}
