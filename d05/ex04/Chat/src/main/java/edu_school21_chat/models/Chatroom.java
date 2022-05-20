package edu_school21_chat.models;
import java.util.List;
import java.util.Objects;
public class Chatroom {
    private long Id;
    private String Name;
    private User Owner;
    private List<Message> Messages;
    public Chatroom(){};
    public Chatroom(long id, String name, User user, List<Message> messages)
    {
        Id = id;Name = name;Owner = user;Messages = messages;
    }
    public long getId()
    {
        return Id;
    }
    public String getName()
    {
        return Name;
    }
    public List<Message> getMessages()
    {
        return Messages;
    }
    public User getOwner()
    {
        return Owner;
    }
    public void setId(long value)
    {
        Id = value;
    }
    public void setName(String str)
    {
        Name = str;
    }
    public void setOwner(User obj)
    {
        Owner = obj;
    }
    public void setMessages(List<Message> lst)
    {
        Messages = lst;
    }
    public boolean equals(Chatroom obj)
    {
        if (Id == obj.getId() && Name == obj.getName()
                && Owner == obj.getOwner() && Messages == obj.getMessages())
            return true;
        else
            return false;
    }
    public int hashCode()
    {
        return Objects.hash(Id, Name, Owner, Messages);
    }
    public String toString()
    {
        return "id=" + Id + ", name='" + Name + '\'' + ", Owner=" + Owner + ", Messages=" + Messages;
    }

    public String toString(String arg) throws IllegalArgumentException
    {
        if (arg.equals("id"))
            return Id + "";
        if (arg.equals("name"))
            return Name;
        if (arg.equals("Owner"))
            return Owner + "";
        if (arg.equals("messages"))
            return Messages + "";
        else
            throw new IllegalArgumentException();
    }
}
