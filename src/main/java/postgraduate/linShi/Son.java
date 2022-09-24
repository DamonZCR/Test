package postgraduate.linShi;

public class Son extends Thread{
   //@SneakyThrows
   @Override
   public void run(){
       try {
           Thread.sleep(1000);

       }catch (InterruptedException e){
           e.printStackTrace();
       }
       System.out.println("run");

   }
    public static void main(String[] args) {
        Son t = new Son();
        t.run();
        System.out.println("dd");
    }
}
