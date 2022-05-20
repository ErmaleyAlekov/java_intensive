package edu_school21_chat.app;
import edu_school21_chat.models.Chatroom;
import edu_school21_chat.models.Message;
import edu_school21_chat.models.User;
import edu_school21_chat.repositories.MessagesRepository;
import edu_school21_chat.repositories.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu_school21_chat.repositories.UsersRepositoryJdbcImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class Program
{
    public static void main(String[] args) throws FileNotFoundException,SQLException
    {
        Connection connection = connect();
        CreateAndInsert(connection, "/resources/schema.sql");
        CreateAndInsert(connection, "/resources/data.sql");
        UsersRepositoryJdbcImpl obj = new UsersRepositoryJdbcImpl(connection);
        List<User> lst = obj.findAll(3,4);
        for (int i=0;i<lst.size();i++)
        {
            System.out.println(lst.get(i).toString());
        }
//        List<User> lst = getUsersFromDb(connection);
//        List<Chatroom> lst2=getRoomsFromDb(connection,lst);
//        List<Message> lst3 = getMessagesFromDb(connection,lst,lst2);
//        User test = new User();
//        MessagesRepository obj = new MessagesRepositoryJdbcImpl(connection,lst,lst2);
//        Optional<Message> om = obj.findById(lst3.get(2).getId());
//        Message m = om.get();
//        System.out.println("ДО ---> "+m.toString());
////        System.out.println(test.toString());
////        m.setAuthor(test);
//        m.setText("TROLOLO");
//        m.setTime(LocalDateTime.now());
//        obj.update(m);
//        lst3 = getMessagesFromDb(connection,lst,lst2);
//        System.out.println("ПОСЛЕ ---> "+ lst3.get(lst3.size() -1).toString());
    }
    public static Connection connect()
    {
        Connection conn = null;
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl("jdbc:postgresql://localhost:5432/chatDB");
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
                new File("/home/ermaley/java_piscine/d05/ex04/Chat/src/main" + filename))
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
        String selectTableSQL = "SELECT *" +
                "FROM chat.users";
        List<User> users = new ArrayList<>();
        try {

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            for (;rs.next();)
            {
                long userid = rs.getInt("id");
                String username = rs.getString("login");
                String userpass = rs.getString("password");
                String createdRooms = rs.getString("createdrooms");
                String allRooms = rs.getString("allrooms");
                List<Long> cid = new ArrayList<>();List<Long> aid = new ArrayList<>();
                if (createdRooms.length() == 1)
                {
                    cid.add(Long.getLong(createdRooms));
                }
                else
                {
                    String arr[] = createdRooms.split(",");
                    if (arr.length == 1)
                        cid.add(Long.getLong(createdRooms));
                    else {
                        for (int i = 0; i < arr.length; i++) {
                            cid.add(Long.getLong(arr[i]));
                        }
                    }
                }
                if (allRooms.length() == 1)
                {
                    aid.add(Long.getLong(allRooms));
                }
                else
                {
                    String arr[] = allRooms.split(",");
                    if (arr.length == 1)
                        cid.add(Long.getLong(createdRooms));
                    else {
                        for (int i = 0; i < arr.length; i++) {
                            aid.add(Long.getLong(arr[i]));
                        }
                    }
                }
                List<Chatroom> c = new ArrayList<>();List<Chatroom> all = new ArrayList<>();
                for (int i=0;i<cid.size();i++)
                {
                    Chatroom New = new Chatroom(cid.get(i),"test",null,null);
                    c.add(New);
                }
                for (int i=0;i<aid.size();i++)
                {
                    Chatroom New = new Chatroom(aid.get(i),"test",null,null);
                    all.add(New);
                }
                User a = new User(userid,username,userpass, c,all);
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
            ResultSet rs = statement.executeQuery(selectTableSQL);
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
            ResultSet rs = statement.executeQuery(selectTableSQL);
            for (;rs.next();)
            {
                long messageid = rs.getLong("id");
                long authorid = rs.getLong("author");
                long roomid = rs.getLong("room");
                String text = rs.getString("text");
                LocalDateTime time = rs.getTimestamp("timestamp").toLocalDateTime();
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
                Message f = new Message(messageid,a,b,text,time);
                m.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }
}
