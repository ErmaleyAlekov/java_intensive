package edu.school21.services;

import edu.school21.models.User;
import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsersServiceImplTest
{
    private static Connection Con = connect();
    public static void main(String[] args) throws FileNotFoundException
    {
        CreateAndInsert(Con,"schema.sql");
        CreateAndInsert(Con,"data.sql");
        checkfindByLogin();
        checkUpdate();
        checkAuthentication();
//        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
    }
    public static DataSource init()
    {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
        return db;
    }
    public static Connection connect()
    {
        Connection connection = null;
        try
        {
            connection = init().getConnection();
            System.out.println("Success connection!");
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
                new File("/home/ermaley/java_piscine/d06/ex03/Tests/src/test/resources/" + filename))
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
    @Test
    public static void checkfindByLogin()
    {
        UsersServiceImpl obj = new UsersServiceImpl();
        User user = obj.findByLogin("ALEX1");
        System.out.println("-----------checkfindByLogin-----------");
        System.out.println(user.toString());
        try
        {
            User user2 = obj.findByLogin("Bob");
            System.out.println(user2.toString());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
    }
    @Test
    public static void checkUpdate()
    {
        UsersServiceImpl obj = Mockito.mock(UsersServiceImpl.class);
        User user = Mockito.verify(obj).findByLogin("ALEX1");
        user.setLogin("ALEXEY");
        user.setPass("qwerty");
        Mockito.verify(obj).update(user);
        List<User> lst = Mockito.verify(obj).findAll();
        System.out.println("-----------checkUpdate-----------");
        for (int i = 0;i<lst.size();i++) {
            System.out.println(lst.get(i).toString());
        }
        System.out.println("--------------------------------------");
    }
    @Test
    public static void checkAuthentication()
    {
        UsersServiceImpl obj = Mockito.mock(UsersServiceImpl.class);
        Mockito.verify(obj).authenticate("ALEX","123");
        List<User> lst = Mockito.verify(obj).findAll();
        System.out.println("-----------checkAuthentication-----------");
        for (int i = 0;i<lst.size();i++) {
            System.out.println(lst.get(i).toString());
        }
        try
        {
            Mockito.verify(obj).authenticate("123234234","sdfsdfsdf");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
    }
}
