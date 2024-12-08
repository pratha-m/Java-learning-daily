package Thread.ThreadCreation;

public class WorldInterface implements Runnable{
    @Override
    public void run() {
        for(;;){
            System.out.println(Thread.currentThread().getName());
        }   
    }
}
