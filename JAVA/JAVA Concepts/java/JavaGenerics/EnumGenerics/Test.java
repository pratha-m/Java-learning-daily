package EnumGenerics;

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY,SUNDAY
}

public class Test {
    public static void main(String[] args) {
        Day d=Day.MONDAY;
        System.out.println(d);

        // Day d="MONDAY"; // gives comilation eror , as we are assigning string type to enum type variable
    }
}
