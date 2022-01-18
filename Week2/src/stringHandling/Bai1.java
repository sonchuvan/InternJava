package stringHandling;
class Ex{
    public boolean check(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
public class Bai1 {
    public static void main(String[] args) {
        Ex ex = new Ex();
        for (int i = 100001; i <= 999999 ; i++) {
            if (ex.check(String.valueOf(i)))
                System.out.print(i+" ");
        }
    }
}
