package BoundedParamerters;

interface Printable{
    void print();
}

class MyNumber extends Number implements Printable{
    private final int value;

    public MyNumber(int value){
        this.value=value;
    }

    @Override
    public void print(){
        System.out.println("Number : "+value);
    }

    @Override
    public int intValue(){
        return value;
    }

    @Override
    public float floatValue(){
        return value;
    }

    @Override 
    public double doubleValue(){
        return value;
    }

    @Override 
    public long longValue(){
        return value;
    }
}

class Boxx<T extends Number & Printable> {
    private T item;

    public Boxx(T item){
        this.item=item;
    }

    public void display(){
        item.print();
    }
    public T getItem(){
        return this.item;
    }
}

public class Test {
    public static void main(String[] args) {
        MyNumber number=new MyNumber(12); 
        Boxx<MyNumber> box=new Boxx<>(number);
        box.display();
    }
}