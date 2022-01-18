package javaException;

import java.util.Scanner;

class UserDefinedException extends Throwable {
    public UserDefinedException(String str)
    {
        // Calling constructor of parent Exception
        super(str);
    }
}
public class TestThrow3 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        try {
            int age = in.nextInt();
            if(age > 18 ){
                throw new Exception("NHai sai dinh dang");
            }
        }catch (Exception us){
            System.out.println(us);
        }
    }
}
