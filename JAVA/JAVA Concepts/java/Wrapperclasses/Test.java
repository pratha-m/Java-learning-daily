class Student {
    int id;
}
public class Test {
    public static void main(String[] args) {
        // Student stud=new Student();
        // stud.id=1;
        // func1(stud);  // asigning new object to arguemnet passed object
        // func2(stud); // chnage the value of field of object
        // System.out.println(stud.id);

        // Integer a=1;
        // Integer b=1;
        // System.out.println(a==b);
        // System.out.println(a.equals(b));
    }
    public static void func1(Student student){
        Student x=new Student();
        x.id=2;
        student=x;
    }
    public static void func2(Student student){
        student.id=2;
    }
}