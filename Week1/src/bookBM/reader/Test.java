package bookBM.reader;
abstract class A{
    public void abc(){
        System.out.println("abc");
    }
}
interface B{
    void abc();
}
public class Test extends A implements B {
    @Override
    public void abc() {
        super.abc();
    }

    public static void main(String[] args) {
        A a = new Test();
    }
}
