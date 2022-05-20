package edu_school21_chat.app;
import edu_school21_chat.models.Chatroom;
import edu_school21_chat.models.Message;
import edu_school21_chat.models.User;
import edu_school21_chat.repositories.MessagesRepository;
import edu_school21_chat.repositories.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Program
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Connection connection = connect();
//        CreateAndInsert(connection, "/resources/schema.sql");
//        CreateAndInsert(connection, "/resources/data.sql");
        MessagesRepository obj = new MessagesRepositoryJdbcImpl(connection);
        List<User> lst = getUsersFromDb(connection);
        List<Chatroom> lst2=getRoomsFromDb(connection,lst);
        Message message = new Message(0, lst.get(0), lst2.get(1), "schacahc!", LocalDateTime.now());
        Message message2 = new Message(1, lst.get(0), lst2.get(1), "schacahc!", LocalDateTime.now());
        obj.save(message);
        obj.save(message2);
        System.out.println("New message id = "+message.getId());
        System.out.println("New message id = "+message2.getId());
//
    }
    public static Connection connect()
    {
        Connection conn = null;
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl("jdbc:postgresql://localhost:5432/chatDB2");
        cfg.setUsername("ermaley");cfg.setPassword("12345");
        HikariDataSource ds = new HikariDataSource(cfg);
        try
        {
            conn = ds.getConnection();
            System.out.println("Connected to the server successfully.");
        } catch (SQLException e )
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void CreateAndInsert(Connection connection, String filename) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(
                new File("/home/ermaley/java_piscine/d05/ex00/Chat/src/main" + filename))
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
    public static List<User> getUsersFromDb(Connection con)
    {
        String selectTableSQL = "SELECT id, login, \"password\"\n" +
                "FROM chat.users";
        List<User> users = new ArrayList<>();
        try {

            Statement statement = con.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            for (;rs.next();)
            {
                long userid = rs.getInt("id");
                String username = rs.getString("login");
                String userpass = rs.getString("password");
                User a = new User(userid,username,userpass, null,null);
                users.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static List<Chatroom> getRoomsFromDb(Connection con, List<User> lst)
    {
        String selectTableSQL = "SELECT id, \"name\", \"owner\"\n" +
                "FROM chat.rooms";
        List<Chatroom> rooms = new ArrayList<>();
        try {

            Statement statement = con.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            for (;rs.next();)
            {
                long roomid = rs.getInt("id");
                String roomname = rs.getString("name");
                long ownerid = rs.getInt("owner");
                for (int i=0;i<lst.size();i++)
                {
                    if (ownerid == lst.get(i).getId())
                    {
                        Chatroom a = new Chatroom(roomid,roomname,lst.get(i), new ArrayList<>());
                        rooms.add(a);
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }
    public static List<Message> getMessagesFromDb(Connection con, List<User> users, List<Chatroom> rooms)
    {
        String selectTableSQL = "SELECT * FROM chat.messages";
        List<Message> m = new ArrayList<>();
        try {

            Statement statement = con.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            // И если что то было получено то цикл while сработает
            for (;rs.next();)
            {
                long messageid = rs.getInt("id");
                long authorid = rs.getInt("author");
                long roomid = rs.getInt("room");
                String text = rs.getString("text");
                String time = rs.getString("timestamp");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
                User a = new User();Chatroom b = new Chatroom();
                for(int j = 0;j<users.size();j++)
                {
                    if (authorid == users.get(j).getId())
                    {
                        a = users.get(j);
                    }
                }
                for(int j = 0;j<rooms.size();j++)
                {
                    if (roomid == rooms.get(j).getId())
                    {
                        b = rooms.get(j);
                    }
                }
                Message f = new Message(messageid,a,b,text,dateTime);
                m.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }
}
