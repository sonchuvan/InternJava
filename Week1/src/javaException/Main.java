package javaException;

public class Main {
    public static void main(String[] args) {

//      int data = 50 / 0; //may throw exception
//      System.out.println("rest of the code");
//        try
//        {
//            int data=50/0; //may throw exception
//        }
//        //handling the exception
//        catch(ArithmeticException e)
//        {
//            System.out.println(e);
//        }
//        System.out.println("rest of the code");
//    }
        try {
            int data = 50 / 0; //may throw exception
            // if exception occurs, the remaining statement will not exceute
            System.out.println("rest of the code");
        }
        // handling the exception
        catch (Exception e) {
            System.out.println(e);
            //sout("some thing")
        } finally {
            System.out.println("end");
        }
    }

}
