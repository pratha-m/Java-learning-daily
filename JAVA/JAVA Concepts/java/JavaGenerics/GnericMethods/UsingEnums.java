package GnericMethods;

enum Operations{
    ADD,SUBTRACT,MULTIPLY,DEVIDE;

    public <T extends Number> double apply(T a,T b){
        switch(this){
            case ADD:return a.doubleValue()+b.doubleValue();
            case SUBTRACT:return a.doubleValue()-b.doubleValue();
            case MULTIPLY:return a.doubleValue()*b.doubleValue();
            case DEVIDE:return a.doubleValue()/b.doubleValue();
            default:return 0;
        }
    }
}

public class UsingEnums {
    public static void main(String[] args) {
        System.out.println(Operations.ADD.apply(10,20));
        System.out.println(Operations.SUBTRACT.apply(10,20));
        System.out.println(Operations.MULTIPLY.apply(10,20));
        System.out.println(Operations.DEVIDE.apply(10,20));
    }
}
