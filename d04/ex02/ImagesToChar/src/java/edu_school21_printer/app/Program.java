package edu_school21_printer.app;
import java.io.IOException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import edu_school21_printer.logic.Logic;
public class Program 
{
    @Parameter(names={"--white="})
    String clr;
    @Parameter(names={"--black="})
    String clr2;
    public static void main(String[] args) throws IOException
    {
        // if (args.length == 2)
        // {
           
            // Logic a = new Logic(str,str2);
            // char[][] chars = a.readImage("",1, 1);
            // a.writeToConsole(chars);
            Program a = new Program();
            JCommander jc = new JCommander(a, args);
            a.run();
        // }
        // else
        // {
        //     System.out.println("Error arguments!");
        //     System.exit(-1);
        // }
    }
    public void run() {
        System.out.printf("%d %d", clr, clr2);
      }
}
