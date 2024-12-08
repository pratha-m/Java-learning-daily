package BoundedParamerters;
public class Box<T extends Number>{
    T num1;
    public Box(T num1) {
        this.num1=num1;
    }    
    public T getNum1(){
        return num1;
    }
}