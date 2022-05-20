package edu.school21.repositories;
import edu.school21.models.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
public class ProductsReposutoryJdbcImplTest
{
    @Test
    public static void checkFindAll(Connection con)
    {
        ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
        final List<Product> EXPECTED_FIND_ALL_PRODUCTS = obj.findAll();
        System.out.println("---------checkFindAll----------");
        for (int i = 0;i<EXPECTED_FIND_ALL_PRODUCTS.size();i++)
        {
            System.out.println(EXPECTED_FIND_ALL_PRODUCTS.get(i));
        }
        System.out.println("----------------------------");
    }
    @Test
    public static void checkFindById(Connection con)
    {
        ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
        Optional<Product> op = obj.findById(Long.valueOf(4));
        final Product EXPECTED_FIND_BY_ID_PRODUCT = op.get();
        System.out.println("---------checkFindById----------");
        System.out.println(EXPECTED_FIND_BY_ID_PRODUCT.toString());
        System.out.println("----------------------------");

    }
    @Test
    public static void checkUpdate(Connection con)
    {
        ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
        Optional<Product> op = obj.findById(Long.valueOf(4));
        Product p = op.get();
        System.out.println("---------checkUpdate----------");
        System.out.println(p.toString());
        p.setName("egg");p.setPrice(1000000);
        obj.update(p);
        op = obj.findById(Long.valueOf(4));
        p = op.get();
        final Product EXPECTED_UPDATED_PRODUCT = p;
        System.out.println(EXPECTED_UPDATED_PRODUCT.toString());
        System.out.println("----------------------------");
    }
    @Test
    public static void checkSave(Connection con)
    {
        ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
        Product p = new Product(Long.valueOf(34),"tree", 3243234);
        obj.save(p);
        List<Product> lst = obj.findAll();
        System.out.println("---------checkSave----------");
        for (int i = 0;i<lst.size();i++)
        {
            System.out.println(lst.get(i));
        }
        System.out.println("----------------------------");
    }
    @Test
    public static void checkDelete(Connection con)
    {
        try {
            ProductsRepositoryJdbcImpl obj = new ProductsRepositoryJdbcImpl(con);
            obj.delete(Long.valueOf(2));
            List<Product> lst = obj.findAll();
            System.out.println("---------checkDelete----------");
            for (int i = 0;i<lst.size();i++) {
                System.out.println(lst.get(i));
            }
            System.out.println("----------------------------");
            obj.delete(Long.valueOf(34));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
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
    public static void main(String[] args) throws FileNotFoundException {
        Connection con = connect();
        CreateAndInsert(con,"schema.sql");
        CreateAndInsert(con,"data.sql");
        checkFindAll(con);
        checkFindById(con);
        checkSave(con);
        checkUpdate(con);
        checkDelete(con);
    }
}
