package app;

import Classes.downloader;
import Classes.textsСomparison;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Program
{
    public static void printDownloardClass()
    {
        System.out.println("fields: ");
        System.out.println("       String folderToDownloard");
        System.out.println("       String URL");
        System.out.println("       boolean status");
        System.out.println("methods: ");
        System.out.println("       void downloard(String filename)");
    }
    public static void printTextsComparison()
    {
        System.out.println("fields: ");
        System.out.println("       String FILE");
        System.out.println("       String FILE2");
        System.out.println("methods: ");
        System.out.println("       void comparison()");
        System.out.println("       void comparison(String file, String file2");
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        Scanner sc = new Scanner(System.in);
        String in = "";
        System.out.println("-------------------------");
        System.out.println("Classes:");
        System.out.println("downloader");
        System.out.println("textComparison");
        System.out.println("-------------------------");
        System.out.println("Enter class name: ");
        in = sc.nextLine();

        if (in.equals("downloader"))
        {
            printDownloardClass();
            System.out.println("-------------------------");
            System.out.println("Let`s create an object");
            System.out.println("folderToDownloard: ");
            String f = sc.nextLine();
            System.out.println("URL: ");
            String f2 = sc.nextLine();
            downloader obj = new downloader(f,f2);
            System.out.println("Object created! downloard{"+ obj.toString()+"}");
            System.out.println("-------------------------");
            System.out.println("Enter name of the field for changing:");
            String field = sc.nextLine();
            System.out.println("Enter value for new field:");
            String value = sc.nextLine();
            Field obj2 = obj.getClass().getDeclaredField(field);
            obj2.setAccessible(true);
            obj2.set(obj,value);
            System.out.println("Object update: downloader{"+obj.toString()+"}");
            System.out.println("-------------------------");
            System.out.println("Enter name of the method for call:");
            in = sc.nextLine();
            if (in.equals("downloard"))
            {
                System.out.println("Enter filename:");
                in = sc.nextLine();
                obj.download(in);
            }
            else {
                System.out.println("Error method!");
                return;
            }
        }
        if (in.equals("textComparison"))
        {
            printTextsComparison();
            System.out.println("-------------------------");
            System.out.println("Let`s create an object");
            System.out.println("FILE: ");
            String file = sc.nextLine();
            System.out.println("FILE2: ");
            String file2 = sc.nextLine();
            textsСomparison obj = new textsСomparison(file, file2);
            System.out.println("Object created! textsСomparison{"+ obj.toString()+"}");
            System.out.println("-------------------------");
            System.out.println("Enter name of the field for changing:");
            String field = sc.nextLine();
            System.out.println("Enter value for new field:");
            String value = sc.nextLine();
            Field obj2 = obj.getClass().getDeclaredField(field);
            obj2.setAccessible(true);
            obj2.set(obj,value);
            System.out.println("Object update: textsСomparison{"+obj.toString()+"}");
            System.out.println("-------------------------");
            System.out.println("Enter name of the method for call:");
            in = sc.nextLine();
            if (in.equals("comparison()"))
            {
                obj.comparison();
            }
            else if(in.equals("comparison(String file, String file2)"))
            {
                System.out.println("Enter file:");
                String str = sc.nextLine();
                System.out.println("Enter file2:");
                String str2 = sc.nextLine();
                obj.comparison(str, str2);
            }
            else {
                System.out.println("Error method!");
            }
        }
        else {
            System.out.println("Error class!");
        }
    }
}
