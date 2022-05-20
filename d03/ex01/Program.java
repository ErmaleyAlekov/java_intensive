package ex01;
import java.util.concurrent.Semaphore;

public class Program
{
    static Semaphore semaphore = new Semaphore(1);

    static class myThread extends Thread 
    {
        myThread(String name, int n, String print){
            super(name);N = n; Print = print;
        }
        private int N;
        private String Print;
        public void run(){
            try{
                semaphore.acquire();
                for (int i = 0;i<N;i++)
                {
                    System.out.println(Print);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread has been interrupted");
            }
            semaphore.release();
            System.out.println("----------------------------------------------");
        }
    }


    public static void main(String[] args) {
        if (args.length == 1)
        {
            try {
                String arr[] = args[0].split("=");
                int count = 0;
                if (arr[0].equals("--count") && arr.length > 1)
                {
                    count = Integer.parseInt(arr[1]);
                }
                else
                {
                    System.err.println("Error argument!");
                    System.exit(-1);
                }
                System.out.println("Main thread started...");
                System.out.println("----------------------------------------------");
                for (int i = 0;i < count;i++)
                {
                    myThread a = new myThread("Fist thread", 1 , "Egg");
                    myThread b = new myThread("Second thread", 1, "Hen");
                    a.start();
                    Thread.sleep(500);
                    b.start();
                    try{
                    a.join(); b.join();
                }
                catch(InterruptedException e){
                
                    System.out.printf("%s has been interrupted", a.getName());
                }
                }
                System.out.println("----------------------------------------------");
                for (int i =0;i<count;i++)
                {
                    System.out.println("Human");
                }
                System.out.println("Main thread finished...");
            } catch (Exception e) {
                System.err.println("Error: exception exist!");
                e.printStackTrace();
                System.exit(-1);
            }   
        }
        else
        {
            System.err.println("Error argument!");
            System.exit(-1);
        }
        
    }
}