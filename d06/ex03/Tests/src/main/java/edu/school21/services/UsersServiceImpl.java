package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.exceptions.EntityNotFoundException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersServiceImpl implements UsersRepository
{
    private Connection Con;
    public UsersServiceImpl(){}
    public UsersServiceImpl(Connection con){Con = con;}
    public List<User> findAll()
    {
        String sql = "SELECT * FROM PUBLIC.USERS";
        List<User> lst = new ArrayList<>();
        try
        {
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                lst.add(new User(rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getBoolean("status")));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    public User findByLogin(String login)
    {
        List<User> lst = findAll();
        User res = null;
        for (int i=0;i< lst.size();i++)
        {
            if (login.equals(lst.get(i).getLogin()))
            {
                res = lst.get(i);
            }
        }
        if (res == null)
            throw new EntityNotFoundException();
        else
            return res;
    }
    public void update(User user)
    {
        if (user == null) throw new EntityNotFoundException();
        List<User> lst = findAll();boolean check = false;
        for (int i = 0;i< lst.size();i++)
        {
            if (user.getId() == lst.get(i).getId())
            {
                check = true;
                break;
            }
        }
        if (!check)
            throw new EntityNotFoundException();
        else
        {
            long id = user.getId();
            String login = user.getLogin();
            String pass = user.getPass();
            boolean status = user.getStatus();
            String sql = "UPDATE PUBLIC.USERS SET login = '"+login+"', password = '"+pass
                    +"', status= "+status+" WHERE id="+id;
            try
            {
                Con.createStatement().executeUpdate(sql);
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    boolean authenticate(String login, String password)
    {
        List<User> lst = findAll();
        boolean check = false; User u = new User();
        for (int i=0;i<lst.size();i++)
        {
            if (lst.get(i).getLogin().equals(login) && lst.get(i).getPass().equals(password)&&!lst.get(i).getStatus())
            {
                u = lst.get(i);
                check = true;
            }
        }
        if (!check)
            throw new AlreadyAuthenticatedException();
        else
        {
            long id = u.getId();
            String sql = "UPDATE PUBLIC.USERS SET status= "+true+" WHERE id= "+id;
            try
            {
                Con.createStatement().executeUpdate(sql);
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
            return true;
        }
    }
    public DataSource init()
    {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
        return db;
    }
    public Connection connect()
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
}
