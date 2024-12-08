package WildcardGenerics;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        // printArrayList(arr);
        // System.out.println(getFirst(arr));
        // printArrayListWild(arr);

        // **Wildcard in generics 
        // Extending wildcard
        // System.out.println(getSum(arr));
        // -extend vs super 
        // extend 
        // List<? extends Number> nums=Arrays.asList(1,2,3);
        // nums.add(12); // compile time error 
        // super 
        // List<? super Integer> nums=Arrays.asList(1,2,3);
        // nums.add(12); // run time error



    }
    public static int getSum(ArrayList<? extends Number> arr){
        int sum=0;
        for(Number ele:arr){
            sum+=ele.intValue();
        }
        return sum;
    }
    // public static int getSum2(ArrayList<? super Integer> arr){
    //     int sum=0;
    //     for(Number ele:arr){
    //         sum+=ele.intValue();
    //     }
    //     return sum;
    // }

    public static <T> void printArrayList(ArrayList<T> list){
        for(T t:list){
            System.out.print(t+" ");
        }
        System.out.println();
    }
    public static Object getFirst(ArrayList<?> list){
        return list.get(0);
    }
    public static void printArrayListWild(ArrayList<?> list){ // it works because it is just reading not returning
        for(Object t:list){
            System.out.print(t+" ");
        }
        System.out.println();
    }
    // public static void copy(ArrayList<?> arr1,ArrayList<?> arr2){ // gives error
    //     for(Object obj:arr1){
    //         arr2.add(obj);  // this line gives erorr becasuese we are adding this to without knowing thee list types
    //     }
    // }
    

}
