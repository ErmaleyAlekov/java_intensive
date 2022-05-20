package edu_school21_chat.repositories;

import java.sql.Connection;

import edu_school21_chat.models.Chatroom;
import edu_school21_chat.models.Message;
import edu_school21_chat.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository
{
    private Connection Conect;
    public MessagesRepositoryJdbcImpl(Connection con)
    {
        Conect = con;
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
                if (id == res.getLong("id"))
                {
                    m = new Message(res.getLong("id"), null, null, res.getString("text"),
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
}
