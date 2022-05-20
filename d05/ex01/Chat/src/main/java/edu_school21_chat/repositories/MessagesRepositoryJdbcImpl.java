package edu_school21_chat.repositories;

import java.sql.Connection;
import edu_school21_chat.models.Message;
import edu_school21_chat.models.Chatroom;
import edu_school21_chat.models.User;
import edu_school21_chat.app.Program;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                    Long authorid = res.getLong("author");
                    Long roomid = res.getLong("room");
                    List<User> lst = Program.getUsersFromDb(Conect);
                    List<Chatroom> lst2 = Program.getRoomsFromDb(Conect,lst);
                    User author = new User();
                    Chatroom room = new Chatroom();
                    for (int i=0;i<lst.size();i++)
                    {
                        if (lst.get(i).getId() == authorid)
                        {
                            author = lst.get(i);
                        }
                    }
                    for (int i=0;i<lst2.size();i++)
                    {
                        if (lst2.get(i).getId() == roomid)
                        {
                            room = lst2.get(i);
                        }
                    }
                    m = new Message(res.getLong("id"), author, room, res.getString("text"),
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
}
