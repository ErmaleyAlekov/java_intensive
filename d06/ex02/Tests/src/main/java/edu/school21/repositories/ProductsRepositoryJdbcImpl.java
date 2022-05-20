package edu.school21.repositories;

import edu.school21.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository
{
    private Connection Con;
    ProductsRepositoryJdbcImpl(Connection con) {Con = con;}
    public List<Product> findAll()
    {
        String sql = "SELECT * FROM PUBLIC.MYTABLE";
        List<Product> lst = new ArrayList<>();
        try
        {
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                lst.add(new Product(rs.getLong("id"),
                        rs.getString("name"), rs.getInt("price")));
            }
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
        return lst;
    }
    public Optional<Product> findById(Long id)
    {
        String sql = "SELECT * FROM PUBLIC.MYTABLE";
        Product res = new Product();
        try
        {
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                if (id == rs.getLong("id"))
                {
                    String name = rs.getString("name");
                    Integer price = rs.getInt("price");
                    res = new Product(id, name, price);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(res);
    }
    public void update(Product product)
    {
        if (product == null) throw new IllegalArgumentException();
        Long id = product.getId();
        Optional<Product> op = findById(id);
        if (op.isEmpty()) {
            System.out.println("Cannot find this id in data base!");
            return;
        }
        String name = product.getName();
        Integer price = product.getPrice();
        String sql = "UPDATE PUBLIC.MYTABLE SET name = '"+name+"', price = "+price+" WHERE id="+id;
        try
        {
            Con.createStatement().executeUpdate(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void save(Product product)
    {
        if (product == null) throw new IllegalArgumentException();
        Long id = product.getId();
        String name = product.getName();
        Integer price = product.getPrice();
        String sql = "INSERT INTO PUBLIC.MYTABLE(NAME,PRICE) VALUES('"+name+"','"+price+"')";
        try
        {
            Con.createStatement().executeUpdate(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void delete (Long id)
    {
        if (id < 0) throw new IllegalArgumentException();
        String sql = "DELETE FROM PUBLIC.MYTABLE WHERE id="+id;
        try
        {
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
