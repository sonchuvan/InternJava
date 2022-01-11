package basic;

public class Bai7 {

    static boolean kt(int n){
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        while (n>0){
            if((n%10)%2==0) return false;
            n = n/10;
        }
        return true;
    }

    public static void main(String[] args) {
        int dem = 0;
        for(int i = 100001;i<999999;i++){
            if (kt(i)) {
                System.out.println(i);
                dem++;
            }
        }
        System.out.println("co "+dem+" so nt 6 chu so toan le");
    }
}
