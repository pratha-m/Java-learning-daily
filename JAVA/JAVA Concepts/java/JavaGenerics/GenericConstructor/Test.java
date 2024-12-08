package GenericConstructor;
class InnerTest{
    public <T> InnerTest(T value){
      System.out.println(value);
    }
}
class InnerTest2{
    public <T extends Number> InnerTest2(T value){
      System.out.println(value);
    }
}

public class Test {
    public static void main(String[] args) {
        InnerTest t1=new InnerTest("hello");
        InnerTest2 t2=new InnerTest2(12);
    }
}
