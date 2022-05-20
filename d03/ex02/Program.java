package ex02;
import java.util.*;
public class Program
{
    public static List<Integer>[] getListsArray(int count,int del,int del2, List<Integer> lst)
    {
        List<Integer>[] res = new ArrayList[count];int index = 0;
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
    public static List<Integer> generateArray(int count)
    {
        List<Integer> lst = new ArrayList<>();
        for (int i =0;i<count;i++)
        {
            double a = 1 + Math.random() * 999;
            int b = (int)a;
            lst.add(b);
        }
        return lst;
    }
    static class myThread extends Thread 
    {
        myThread(String name,List<Integer> lst, int start, int end)
        {
            Name =name;Lst = lst;Start = start;End = end;
        }
        List<Integer> Lst;
        String Name;
        int Start;int End; 
        int summa = 0;int sums = 0;
        public void run()
        {
            try
            {
                for (int i = 0;i<Lst.size();i++)
                {
                    summa += Lst.get(i);
                }
            }
            catch(Exception e)
            {
                System.out.println("Thread has been interrupted");
            }
            sums = Lst.size();
            System.out.println(Name + ": Summs from range ("+ Start +" to " + End + ")" + " = " + sums + " Summa integers in array = " + summa);
            System.out.println("----------------------------------------------");
        }
    }

    public static void main(String[] args) {
        if (args.length == 2)
        {
            try {
                String arr[] = args[0].split("=");
                String arr2[] = args[1].split("=");
                int count = 0;int count2 = 0;
                if ((arr[0].equals("--arraySize") && arr.length > 1) && (arr2[0].equals("--threadsCount") && arr2.length > 1))
                {
                    count = Integer.parseInt(arr[1]);
                    count2 = Integer.parseInt(arr2[1]);
                }
                else
                {
                    System.err.println("Error argument!");
                    System.exit(-1);
                }
                if (count <=0 || count > 2000000 || count2 > count)
                {
                    System.err.println("Error argument!");
                    System.exit(-1);
                }
                List<Integer> lst = generateArray(count);int del2 = lst.size() % count2;
                int del = lst.size() / count2;int start = 0; int end = del;
                List<Integer>[] lst2 = getListsArray(count2,del,del2, lst);
                myThread threads[] = new myThread[count2];
                System.out.println("----------------------------------------------");
                for (int i = 0;i < count2;i++)
                {
                    threads[i] = new myThread("Thread" + i, lst2[i], start, end);
                    threads[i].start();
                    start += del;end += del;
                    if (i == count2 - 1)
                    {end += del2;}
                    try
                    {
                    threads[i].join();}
                    catch(InterruptedException e){
                    System.out.println("Error");}
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