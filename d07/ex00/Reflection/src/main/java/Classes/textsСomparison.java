package Classes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class textsСomparison
{
    private String FILE;
    private String FILE2;
    public textsСomparison()
    {
        FILE = "/home/ermaley/java_piscine/d07/ex00/Reflection/src/main/resources/A.txt";
        FILE2 = "/home/ermaley/java_piscine/d07/ex00/Reflection/src/main/resources/B.txt";
    }
    public textsСomparison(String file, String file2) {FILE = file;FILE2=file2;}
    private Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder()
    {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
    public String toString()
    {
        return "FILE = "+FILE+" FILE2 = "+ FILE2;
    }
    public void comparison()
    {
        try
        {
            List<String> lst4 = Files.readAllLines(Paths.get(FILE));
            List<String> lst5 = Files.readAllLines(Paths.get(FILE2));
            Scanner scanner = new Scanner(new File(FILE), "UTF-8")
                    .useDelimiter("[^\\p{L}\\p{Digit}]+");
            Scanner scanner2 = new Scanner(new File(FILE2), "UTF-8")
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
            Path dir = Paths.get("/home/ermaley/java_piscine/d07/ex00/Reflection/src/main/resources");
            Path File = dir.resolve("dictionary.txt");
            Files.createFile(File);
            double Numerator = 0;
            for (int i = 0;i<A.size();i++)
            {Numerator += A.get(i)* B.get(i);
                if (A.get(i) == 1 && B.get(i) == 0)
                {Files.writeString(File, lst.get(i) + " ", StandardOpenOption.APPEND);}
                if (B.get(i) == 1 && A.get(i) == 0)
                {Files.writeString(File, lst.get(i) + " ",StandardOpenOption.APPEND);}}
            double Denominator = 0.0;int mA = 0;int mB = 0;
            for (int i =0;i<A.size();i++)
            {mA += A.get(i) * A.get(i);}
            for (int i =0;i<B.size();i++)
            {mB += B.get(i) * B.get(i);}
            Denominator = Math.sqrt(mA) * Math.sqrt(mB);
            double similarity = Numerator / Denominator;
            System.out.println("Similarity = " + similarity);
        }
        catch (Exception e)
        {
            System.err.println("Error: exception exist!");
            System.exit(-1);
        }
    }
    public void comparison(String file, String file2)
    {
        try
        {
            List<String> lst4 = Files.readAllLines(Paths.get(file));
            List<String> lst5 = Files.readAllLines(Paths.get(file2));
            Scanner scanner = new Scanner(new File(file), "UTF-8")
                    .useDelimiter("[^\\p{L}\\p{Digit}]+");
            Scanner scanner2 = new Scanner(new File(file2), "UTF-8")
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
            Path dir = Paths.get("/home/ermaley/java_piscine/d07/ex00/Reflection/src/main/resources");
            Path File = dir.resolve("dictionary.txt");
            Files.createFile(File);
            double Numerator = 0;
            for (int i = 0;i<A.size();i++)
            {Numerator += A.get(i)* B.get(i);
                if (A.get(i) == 1 && B.get(i) == 0)
                {Files.writeString(File, lst.get(i) + " ", StandardOpenOption.APPEND);}
                if (B.get(i) == 1 && A.get(i) == 0)
                {Files.writeString(File, lst.get(i) + " ",StandardOpenOption.APPEND);}}
            double Denominator = 0.0;int mA = 0;int mB = 0;
            for (int i =0;i<A.size();i++)
            {mA += A.get(i) * A.get(i);}
            for (int i =0;i<B.size();i++)
            {mB += B.get(i) * B.get(i);}
            Denominator = Math.sqrt(mA) * Math.sqrt(mB);
            double similarity = Numerator / Denominator;
            System.out.println("Similarity = " + similarity);
        }
        catch (Exception e)
        {
            System.err.println("Error: exception exist!");
            System.exit(-1);
        }
    }
}
