package Thread.ThreadStates;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("RUN METHOD RUNING");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        MyThread t1=new MyThread();
        System.out.println(t1.getState()); // new, as new thread is created
        t1.start(); 
        System.out.println(t1.getState()); // using t1.start() thread is in running state
        Thread.sleep(100); 
        System.out.println(t1.getState()); // run method is running
        t1.join(); // wait for t1 to finish
        System.out.println(t1.getState()); // terminated
    }
}
