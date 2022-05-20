package ex01;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

import java.lang.Math;
public class Program {
    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() 
    {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            try
            {
                List<String> lst4 = Files.readAllLines(Paths.get(args[0]));
                List<String> lst5 = Files.readAllLines(Paths.get(args[1]));
                Scanner scanner = new Scanner(new File(args[0]), "UTF-8")
                    .useDelimiter("[^\\p{L}\\p{Digit}]+");
                Scanner scanner2 = new Scanner(new File(args[1]), "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");
                List<String> lst = new ArrayList<>();
                String[] lst2 = new String[100000];
                String[] lst3 = new String[100000];
                List<Integer> A = new ArrayList<>();
                List<Integer> B = new ArrayList<>();
                Map<String, Integer> freqMap = new HashMap<>();
                scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));
                scanner2.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));
                freqMap.entrySet().stream().sorted(descendingFrequencyOrder()).limit(1000).map(Map.Entry::getKey).forEach(lst::add);
                for (int i=0;i<lst4.size();i++)
                {lst2 = lst4.get(i).split(" ");}
                for (int i=0;i<lst5.size();i++)
                {lst3 = lst5.get(i).split(" ");}
                for (int i =0;i<lst.size();i++)
                {
                    int count = 0;
                    for (int j = 0;j <lst2.length;j++)
                    {
                        if (lst.get(i).equals(lst2[j]))
                        {count++;}
                    }
                    A.add(count);
                }
                for (int i =0;i<lst.size();i++)
                {
                    int count = 0;
                    for (int j = 0;j <lst3.length;j++)
                    {
                        if (lst.get(i).equals(lst3[j]))
                        {count++;}
                    }
                    B.add(count);
                }
                Path dir = Paths.get("/home/ermaley/java_piscine/d02/ex01");
                Path file = dir.resolve("dictionary.txt");
                Files.createFile(file);
                double Numerator = 0;
                for (int i = 0;i<A.size();i++)
                {Numerator += A.get(i)* B.get(i);
                    if (A.get(i) == 1 && B.get(i) == 0)
                    {Files.writeString(file, lst.get(i) + " ",StandardOpenOption.APPEND);}
                    if (B.get(i) == 1 && A.get(i) == 0)
                    {Files.writeString(file, lst.get(i) + " ",StandardOpenOption.APPEND);}}
                double Denominator = 0.0;int mA = 0;int mB = 0;
                for (int i =0;i<A.size();i++)
                {mA += A.get(i) * A.get(i);}
                for (int i =0;i<B.size();i++)
                {mB += B.get(i) * B.get(i);}
                Denominator = Math.sqrt(mA) * Math.sqrt(mB);
                System.out.println("Denominator = " + Denominator);
                System.out.println("Numerator = " + Numerator);
                double similarity = Numerator / Denominator;
                System.out.println("Similarity = " + similarity);
            }
            catch (Exception e)
            {
                System.err.println("Error: exception exist!");
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
