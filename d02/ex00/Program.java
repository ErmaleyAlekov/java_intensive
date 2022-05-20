package ex00;
import java.io.IOException;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;
public class Program
{
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
    public static String bytesToHex(byte[] bytes) {
    byte[] hexChars = new byte[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars, StandardCharsets.UTF_8);
}
    public static void main(String[] args) throws IOException
    {    
        Scanner in = new Scanner(System.in);
        String str = "";
        String res = "";
        while (true)
        {
            try {
                System.out.println("Enter the current path to file.");
                System.out.print("->");
                str = in.nextLine();
                if (str.equals("42"))
                {in.close();return;}
                Path path = Paths.get(str);
                byte[] raw = java.nio.file.Files.readAllBytes(path);
                List<String> lst = Files.readAllLines(Paths.get("/home/ermaley/java_piscine/d02/ex00/signatures.txt"));
                String array[] = new String[10];
                String array3[] = new String[10];
                String array2[]= new String[10];
                for (int i = 0;i < lst.size();i++)
                {
                    String arr[] = lst.get(i).split(" ");
                    array[i] = arr[1];
                    array3[i] = arr[0];
                }
                for (int i = 0;i<array.length;i++)
                {
                    byte[] raw2 = new byte[array[i].length() /2];
                    for (int j = 0;j<array[i].length() /2;j++)
                    {
                        raw2[j] = raw[j];
                    }
                    array2[i] = bytesToHex(raw2);
                }
                for (int i =0;i<10;i++)
                {
                    if (array2[i].equals(array[i]))
                    {
                        res = "PROCESSED";
                        Path path2 = Paths.get("/home/ermaley/java_piscine/d02/ex00/result.txt");
                        Files.writeString(path2, array3[i],StandardOpenOption.APPEND);
                        break;
                    }
                    else
                    {res= "UNDEFINED";}
                }
                System.out.println(res);
            } catch (Exception e) {
                System.err.println("Error: exception exist!");
                System.exit(-1);
            }
        }
    }
}