package ex00;

class myThread extends Thread 
{
    myThread(String name, int n, String print){
        super(name);N = n; Print = print;
    }
    private int N;
    private String Print;
    public void run(){
            
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            for (int i = 0;i<N;i++)
            {
                System.out.println(Print);
                Thread.sleep(500);
            }
        }
        catch(Exception e)
        {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class Program
{
    
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
                myThread a = new myThread("Fist thread", count , "Egg");
                myThread b = new myThread("Second thread", count, "Hen");
                a.start();b.start();
                try{
                    a.join(); b.join();
                }
                catch(InterruptedException e){
                
                    System.out.printf("%s has been interrupted", a.getName());
                }
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