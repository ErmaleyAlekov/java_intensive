package edu_school21_printer.app;
import java.io.IOException;

import edu_school21_printer.logic.Logic;
public class Program 
{
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            String str = args[0];
            String str2 = args[1];
            if (str.length() != 1 && str2.length() != 1)
            {
                System.out.println("Error arguments!");
                System.exit(-1);
            }
            Logic a = new Logic(str,str2);
            char[][] chars = a.readImage("/home/ermaley/java_piscine/d04/it.bmp",1, 1);
            a.writeToConsole(chars);
        }
        else
        {
            System.out.println("Error arguments!");
            System.exit(-1);
        }
    }
}
