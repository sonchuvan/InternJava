package javaException;

public class Main {
    public static void main(String[] args) {

      //int data = 50 / 0; //may throw exception
      //System.out.println("rest of the code");
        try
        {
            int data=50/2; //may throw exception
            try {
                data = 50/0;
            }
            catch (Exception e){
                System.out.println();
            }
        }
        //handling the exception
        catch(NullPointerException e)
        {
            System.out.println("e");
        }catch (Throwable e){

        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("rest of the code");
    }
//        try {
//            int data = 50 / 0; //may throw exception
//            // if exception occurs, the remaining statement will not exceute
//            System.out.println("rest of the code");
//        }
//        // handling the exception
//        catch (Exception e) {
//            System.out.println(e);
//            //sout("some thing")
//        } finally {
//            System.out.println("end");
//        }
//
//    }

}
