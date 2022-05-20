package edu.school21.repositories;

import edu.school21.models.Product;
import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EmbeddedDataSourceTest
{
    @BeforeEach
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
    public static void main(String[] args) throws FileNotFoundException
    {
        Connection con = connect();
        CreateAndInsert(con,"schema.sql");
        CreateAndInsert(con,"data.sql");
        ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
        List<Product> a = obj.findAll();
        for (int i = 0;i<a.size();i++)
            System.out.println(a.get(i));
        Optional<Product> op = obj.findById(Long.valueOf(5));
        System.out.println(op);
        Product p = op.get();
        p.setName("chocolate");
        p.setPrice(21);
        obj.update(p);
        Product l = new Product(Long.valueOf(23),"coca-cola",42);
        obj.save(l);
        obj.delete(Long.valueOf(3));
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
    }
}
