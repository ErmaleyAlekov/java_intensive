package edu_school21_chat.models;
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
        System.out.print("Creating tables --->");
        CreateAndInsert(connection, "/resources/schema.sql");
        System.out.println(" tables created!");
        System.out.print("Add tables information --->");
        CreateAndInsert(connection, "/resources/data.sql");
        System.out.println(" data inserted");
        List<User> lst = getUsersFromDb(connection);
        for (int i = 0;i<lst.size();i++)
            System.out.println(lst.get(i).toString());
        List<Chatroom> lst2=getRoomsFromDb(connection,lst);
        for (int i = 0;i<lst2.size();i++)
            System.out.println(lst2.get(i).toString());
        List<Message> lst3=getMessageFromDb(connection,lst,lst2);
        for (int i = 0;i<lst3.size();i++)
            System.out.println(lst3.get(i).toString());
    }
    public static Connection connect()
    {
        Connection conn = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chatDB2",
                    "ermaley", "12345");
            System.out.println("Connected to the server successfully.");
        } catch (SQLException e )
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException a)
        {
            System.out.println("Class not found " + a.getMessage());
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
    public static List<Message> getMessageFromDb(Connection con, List<User> users, List<Chatroom> rooms)
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
                    if (authorid == rooms.get(j).getId())
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
