package Interface;

public class Parent {

    static class C implements A,B{
        @Override
        public void multi(int a, int b) {
            System.out.println(a*b);
        }
        @Override
        public void sum(int a, int b) {
            System.out.println(a+b);
        }
    }
    static void main()
    {
        C c= new C();
        c.multi(10,10);
        c.sum(10,10);
    }
}
