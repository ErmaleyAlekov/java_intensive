package ex02;
import java.io.*;
import java.util.Scanner;
public class Program 
{
    public static String cmdCD(String dir, String cmd)
    {
        String pwd = dir;
        File wd = new File(dir);
        System.out.println(wd);
        Process proc = null;
        try {
        proc = Runtime.getRuntime().exec("/bin/sh", null, wd);
        }
        catch (IOException e) {
            System.out.println("Нет такого файла или каталога!");
            return "blablabla";
        }
        if (proc != null) 
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
            out.println(cmd);
            out.println("exit");
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                proc.waitFor();
                in.close();
                out.close();
                proc.destroy();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pwd;
    }
    public static void main(String[] args) throws IOException
    {
        if (args.length == 1)
        {
            try 
            {
                String arg[] = args[0].split("=");
                if (arg.length > 2 || !arg[0].equals("--current-folder")|| arg.length == 1)
                {System.err.println("Error argument!");
                System.exit(-1);}
                String pwd = arg[1];
                Scanner in = new Scanner(System.in);
                String input = "";
                System.out.println(pwd);
                while (!input.equals("exit"))
                {
                    System.out.print("->");
                    input = in.nextLine();
                    String []arr3 = input.split(" ");
                    if (arr3[0].equals("cd"))
                    {
                        String check = "";
                        if (arr3[1].indexOf('/') == -1)
                        {check = cmdCD(pwd+ "/" + arr3[1],"pwd");
                            if (check.equals(pwd+ "/" + arr3[1])) {pwd = check;}}
                        else
                        {check = cmdCD(arr3[1],"pwd");}
                    }
                    else
                    {pwd = cmdCD(pwd,input);}
                }
            } catch (Exception e) {
                System.err.println("Exception happened");
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
