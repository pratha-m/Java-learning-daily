package GnericMethods;
public class Test {
    public static <T> void printArray(T[] arr){
        for(T ele:arr) System.out.println(ele);
        System.out.println();
    }
    public static <T> void display(T element){
        System.out.println("Gneric Called : "+element);
        System.out.println();
    }
    public static void display(Integer element){
        System.out.println("Integer Called : "+element);
        System.out.println();
    }
    public static void main(String[] args) {
        // Integer arr[]={1,2,3,7,8};        
        // printArray(arr);

        // String arr[]={"hello","world"};
        // printArray(arr);

        // display(123);
        // display(78.9);
    }
}
