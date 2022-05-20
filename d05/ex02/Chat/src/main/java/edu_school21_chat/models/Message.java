package edu_school21_chat.models;
import java.time.LocalDateTime;
import java.util.Objects;
public class Message
{
    private long Id;
    private User Author;
    private Chatroom Room;
    private String Text;
    private LocalDateTime Time;
    public Message(long id, User obj, Chatroom roomObj, String text, LocalDateTime time)
    {
        Id = id;Author = obj;Room = roomObj;Text = text;Time = time;
    }
    public long getId()
    {
        return Id;
    }
    public User getAuthor()
    {
        return Author;
    }
    public Chatroom getRoom()
    {
        return Room;
    }
    public String getText()
    {
        return Text;
    }
    public LocalDateTime getTime()
    {
        return Time;
    }
    public void setId(long id)
    {
        Id=id;
    }
    public void setAuthor(User obj)
    {
        Author = obj;
    }
    public void setRoom(Chatroom obj)
    {
        Room = obj;
    }
    public void setText(String str)
    {
        Text = str;
    }
    public void setTime(LocalDateTime time)
    {
        Time = time;
    }

    public boolean equals(Message obj) throws NullPointerException
    {
        if (obj == null)
            throw new NullPointerException();
        if (Id == obj.getId() && Author == obj.getAuthor()
            && Room == obj.getRoom() && Text == obj.getText() && Time == obj.getTime())
            return true;
        else
            return false;
    }
    public int hashCode()
    {
        return Objects.hash(Id,Author,Room,Text,Time);
    }
    public String toString()
    {
        return "id="+Id+" autor="+Author+" chatroom="+Room+" text="+Text+" time="+Time;
    }
    public String toString(String arg) throws IllegalArgumentException,NullPointerException
    {
        if (arg == null)
            throw new NullPointerException();
        if (arg.equals("id"))
            return Id+"";
        if (arg.equals("autor"))
            return Author+"";
        if (arg.equals("room"))
            return Room+"";
        if (arg.equals("text"))
            return Text;
        if (arg.equals("time"))
            return Time+"";
        else
            throw new IllegalArgumentException();
    }
}