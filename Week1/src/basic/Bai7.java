package basic;

public class Bai7 {

    static boolean checkOdd(int n){
        while (n>0){
            if((n%10)%2==0) return false;
            n = n/10;
        }
        return true;
    }
    static boolean checkPrimeNumber(int n){
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int dem = 0;
        for(int i = 100001;i<999999;i++){
            if (checkPrimeNumber(i) && checkOdd(i)) {
                System.out.println(i);
                dem++;
            }
        }
        System.out.println("co "+dem+" so nt 6 chu so toan le");
    }
}
