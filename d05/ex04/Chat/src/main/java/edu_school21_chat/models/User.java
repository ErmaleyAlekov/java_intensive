package edu_school21_chat.models;
import java.util.List;
import java.util.Objects;
public class User
{
    private long Id;
    private String Login;
    private String Pass;
    private List<Chatroom> createdRooms;
    private List<Chatroom> allRooms;
    public User() {}
    public User(long id, String log, String pass, List<Chatroom> created, List<Chatroom> all)
    {
        Id = id;Login = log;Pass = pass;createdRooms = created;allRooms = all;
    }
    public long getId()
    {
        return Id;
    }
    public String getLogin()
    {
        return Login;
    }
    public String getPass()
    {
        return Pass;
    }
    public List<Chatroom> getCreatedRooms()
    {
        return createdRooms;
    }
    public List<Chatroom> getAllRooms()
    {
        return allRooms;
    }
    public void setId(long id)
    {
        Id = id;
    }
    public void setLogin(String login)
    {
        Login = login;
    }
    public void setPass(String pass)
    {
        Pass = pass;
    }
    public void setCreatedRooms(List<Chatroom> lst)
    {
        createdRooms = lst;
    }
    public void setAllRooms(List<Chatroom> lst)
    {
        allRooms = lst;
    }

    public boolean equals(User obj)
    {
        if (obj == null)
            return false;
        if (Id == obj.getId() && Login == obj.getLogin() && Pass == obj.getPass()
            && createdRooms == obj.getCreatedRooms() && allRooms == obj.getAllRooms())
            return true;
        else
            return false;
    }
    public int hashCode()
    {
        return Objects.hash(Id,Login,Pass,createdRooms,allRooms);
    }
    public String toString()
    {
        return "id="+Id+" login="+Login+" password="+Pass+" created rooms="+createdRooms+" all rooms="+ allRooms;
    }
    public String toString(String arg) throws IllegalArgumentException,NullPointerException
    {
        if (arg == null)
            throw new NullPointerException();
        if (arg.equals("id"))
            return Id+"";
        if (arg.equals("login"))
            return Login+"";
        if (arg.equals("password"))
            return Pass+"";
        if (arg.equals("created"))
            return createdRooms+"";
        if (arg.equals("all"))
            return allRooms+"";
        else
            throw new IllegalArgumentException();
    }
}