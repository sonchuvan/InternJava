package stringHandling;
public class Bai1 {
    static boolean checkReverse(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Các số nghịch đảo có 6 chữ số");
        for (int i = 100001; i <= 999999 ; i++) {
            if (checkReverse(String.valueOf(i)))
                System.out.print(i+" ");
        }
    }
}
