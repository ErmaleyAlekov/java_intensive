package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberWorkerTest
{
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
            107, 109, 113, 127, 131, 137, 139, 149, 151, 157,
            163, 167, 173, 179, 181, 191, 193, 197, 199})
    public static void isPrimeForPrimes()
    {
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
                107, 109, 113, 127, 131, 137, 139, 149, 151, 157,
                163, 167, 173, 179, 181, 191, 193, 197, 199};
        for (int i =0;i<arr.length;i++)
        {
            if (!NumberWorker.isPrime(arr[i]))
            {
                System.err.println("Incorrect function implementation!");
                return;
            }
        }
        System.out.println("isPrimeForPrimes: All right!");
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32,
            33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56,
            57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80,
            81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100})
    public static void isPrimeForNotPrimes()
    {
        int[] array = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32,
                33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56,
                57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80,
                81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100};
        for (int i : array)
        {
            if (i == array.length)
                break;
            if (NumberWorker.isPrime(array[i]))
            {
                System.err.println("Incorrect function implementation!");
                return;
            }
        }
        System.out.println("isPrimeForNotPrimes: All right!");
    }
    @ParameterizedTest
    @ValueSource(ints = {-1,-2,-3,-4,-5,-6,-7,-8,-9,0,1})
    public static void isPrimeForIncorrectNumbers()
    {
        int[] array = {-1,-2,-3,-4,-5,-6,-7,-8,-9,0,1};
        int i = 0;
        for (int j : array)
        {
            try
            {
                NumberWorker.isPrime(array[j]);
            }
            catch (Exception e)
            {
                i++;
            }
        }
        if (i < array.length)
            System.err.println("Incorrect function implementation!");
        else
            System.out.println("isPrimeForIncorrectNumbers: All right!");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public static void digitsSumTest() throws FileNotFoundException
    {
        Scanner scanner = new Scanner(
                new File("/home/ermaley/java_piscine/d06/ex00/Tests/src/test/resources/data.csv"))
                .useDelimiter(";");
        List<String> lst = new ArrayList<>();
        try {
            while (scanner.hasNext())
            {
                lst.add(scanner.next().trim());
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        for (String s : lst)
        {
            String[] arr = s.split(",");
            if (arr.length == 2)
            {
                int number = Integer.parseInt(arr[0]);
                int sum = Integer.parseInt(arr[1]);
                if (sum != NumberWorker.digitsSum(number))
                {
                    System.err.println("Incorrect function implementation!");
                    return;
                }
            }
        }
        System.out.println("digitsSumTest: All right!");
    }
    public static Connection connect()
    {
        Connection connection = null;
        try
        {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
            dataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001/xdb");
            dataSource.setUsername("SA");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            System.out.println("Success connection to "+dataSource.getUrl());
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static void CreateAndInsert(Connection connection, String filename) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(
                new File("/home/ermaley/java_piscine/d06/ex01/Tests/src/test/resources/" + filename))
                .useDelimiter(";");
        try {
            while (scanner.hasNext()) {
                connection.createStatement().execute(scanner.next().trim());
            }
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
        scanner.close();
    }
    public static void main(String[] args) throws FileNotFoundException, SQLException
    {
        Connection con = connect();
        CreateAndInsert(con,"schema.sql");
        CreateAndInsert(con,"data.sql");
    }
}
