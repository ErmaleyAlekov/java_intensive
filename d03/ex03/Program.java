package ex03;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
public class Program
{
    public static List<String>[] getListsArray(int count,int del,int del2, List<String> lst)
    {
        List<String>[] res = new ArrayList[count];int index = 0;
        for (int i = 0;i<count;i++)
        {
            res[i] = new ArrayList<>();
        }
        int o = 0;
        for (int i = 0; i< lst.size();i++)
        {
            for (int j = 0;j< del && i < lst.size();j++,i++)
            {
                res[index].add(lst.get(i));
                o = i;
            }
            index++;
        }
        for (int i = 0;i<res.length;i++)
        {
            for (int j = 0;j<res.length;j++)
            {
                if (res[j].size() < res[i].size())
                {
                    res[j].add(lst.get(o));
                }
            }
        }
        if (del2 > 0)
        {
            int g = lst.size() - del2;
            for(int i = g;i<lst.size();i++)
            {
                res[count -1].add(lst.get(i));
            }
        }
        return res;
    }
    private static void download(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
    static class myThread extends Thread 
    {
        myThread(String name,String lst, int start, String out)
        {
            Name =name;Lst = lst;Start = start;outPut = out;
        }
        String Lst;
        String Name;
        String outPut;
        String buffer[];
        int Start;int End;
        public void run()
        {
            try
            {
                buffer = Lst.split("/");
                System.out.println(Name + " start download file " + Start);
                download(Lst, outPut+"/" + buffer[buffer.length - 1]);
                System.out.println(Name + " finish download file " + Start);
                Start++;
            }
            catch(Exception e)
            {
                System.out.println("Thread has been interrupted");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 1)
        {
            try {
                String arr2[] = args[0].split("=");
                int count2 = 0;
                if ((arr2[0].equals("--threadsCount") && arr2.length > 1))
                {
                    count2 = Integer.parseInt(arr2[1]);
                }
                else
                {
                    System.err.println("Error argument!");
                    System.exit(-1);
                }
                List<String> lst = new ArrayList<>();
                String fileName = "/home/ermaley/java_piscine/d03/ex03/files";
                Path path = Paths.get(fileName);
                if (!Files.exists(path))
                {Files.createDirectory(path);}
                try {
                    lst = Files.readAllLines(Paths.get("/home/ermaley/java_piscine/d03/ex03/files_urls.txt"));
                } catch (Exception e) {
                    System.err.println("Error: file not found!");
                    e.printStackTrace();
                    System.exit(-1);
                }
                if (count2 > lst.size())
                {
                    System.out.println("Count of threads = count of files!");
                    count2 = lst.size();
                }
                myThread threads[] = new myThread[count2];
                System.out.println("----------------------------------------------");
                for (int i = 0;i < lst.size();i++)
                {
                    for (int j = 0;j<threads.length;j++,i++)
                    {
                        if (i >= lst.size())
                        {break;}
                        try {
                            threads[j] = new myThread("Thread" + j, lst.get(i), i, fileName);
                            threads[j].start();
                        } catch (Exception e) {
                            myThread reserveThread = new myThread("Thread" + j, lst.get(i), i, fileName);
                            reserveThread.start();
                        }
                    }
                }
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