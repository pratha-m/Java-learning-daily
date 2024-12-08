package Thread.ThreadCreation;

public class WorldClass extends Thread{
    @Override
    public void run(){
        for(;;){
            System.out.println(Thread.currentThread().getName());
        }    
    }
}
 