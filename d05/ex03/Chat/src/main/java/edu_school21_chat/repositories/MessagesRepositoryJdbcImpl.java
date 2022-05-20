package edu_school21_chat.repositories;

import java.sql.Connection;

import edu_school21_chat.models.Chatroom;
import edu_school21_chat.models.Message;
import edu_school21_chat.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository
{
    private Connection Conect;
    private List<User> u;
    private List<Chatroom> r;
    public MessagesRepositoryJdbcImpl(Connection con, List<User> user, List<Chatroom> room)
    {
        Conect = con;u=user;r=room;
    }
    public Optional<Message> findById(Long id)
    {
        Message m = null;
        ResultSet res = null;
        String sql = "SELECT * FROM chat.messages";
        try
        {
            Statement st = Conect.createStatement();
            res = st.executeQuery(sql);
            while (res.next())
            {
                if (id == res.getLong("id")) {
                    long uid = res.getLong("author");
                    User author = new User();
                    for (int i = 0;i<u.size();i++)
                    {
                        if (uid == u.get(i).getId())
                            author = u.get(i);
                    }
                    long rid = res.getLong("room");
                    Chatroom chatroom = new Chatroom();
                    for (int j=0;j<r.size();j++)
                    {
                        if (rid == r.get(j).getId())
                            chatroom = r.get(j);
                    }
                    m = new Message(id, author, chatroom, res.getString("text"),
                            res.getTimestamp("timestamp").toLocalDateTime());
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(m);
    }
    public void save(Message obj) throws NotSavedSubEntityException
    {
        if (obj == null)
            throw new NotSavedSubEntityException();
        User a = obj.getAuthor();
        Chatroom b = obj.getRoom();
        String txt = obj.getText();
        LocalDateTime time = obj.getTime();
        Long id = a.getId();boolean check = false;
        String sqlCheckId = "SELECT * FROM chat.users";
        String sqlSaveMsg = "INSERT INTO chat.messages (author, room, \"text\", \"timestamp\")\n" +
                " VALUES ("+a.getId()+","+b.getId()+",'"+txt+"','"+time+"')";
        System.out.println(sqlSaveMsg);
        try
        {
            Statement st = Conect.createStatement();
            ResultSet res = st.executeQuery(sqlCheckId);
            if (res.next())
            {
                if (id == res.getLong("id"))
                    check = true;
            }
            if (check == false)
            {
                throw new NotSavedSubEntityException();
            }
            Conect.createStatement().executeUpdate(sqlSaveMsg);
            res = st.executeQuery("SELECT * FROM chat.messages");
            while (res.next())
            {
                id = res.getLong("id");
            }
            obj.setId(id);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }
    public void update(Message obj) throws NotSavedSubEntityException
    {
        if (obj == null)
            throw new NotSavedSubEntityException();
        long id = obj.getId();

        User a = obj.getAuthor();
        Chatroom b = obj.getRoom();
        long uid = a.getId();boolean check = false;
        for (int i = 0;i<u.size();i++)
        {
            if (uid == u.get(i).getId())
                check = true;
        }
        if (check == false)
            throw new NotSavedSubEntityException();
        else
            check = false;
        long rid = b.getId();
        for (int j=0;j<r.size();j++)
        {
            if (rid == r.get(j).getId())
                check = true;
        }
        if (check == false)
            throw new NotSavedSubEntityException();
        String txt = obj.getText();
        LocalDateTime time = obj.getTime();
        if (time == null)
            time = LocalDateTime.now();
        String sqlUpdate = "UPDATE chat.messages SET author = " + a.getId()+", room="+b.getId()
                + ", text = '"+txt+"', timestamp = '"+ time+"' WHERE id = "+id;
        try {
            Conect.createStatement().executeUpdate(sqlUpdate);
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }
}
