package edu_school21_chat.repositories;
import edu_school21_chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;
public interface MessagesRepository
{
    Optional<Message> findById(Long id) throws SQLException;
    void save(Message obj);
    void update(Message obj);
}
