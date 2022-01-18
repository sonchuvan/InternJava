package javaException;

public class TestExceptionPropagation {
    void m()/* throws IOException */{
        int data = 50 / 0;
        //throw new java.io.IOException("exx");
    }
    void f() throws Exception{
        int a,b=0;
        a = 4/b;
    }

    void n(){
        m();
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }

    public static void main(String args[]) {
        TestExceptionPropagation obj = new TestExceptionPropagation();
        obj.p();
        System.out.println("normal flow...");
    }
}
