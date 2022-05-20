package edu_school21_chat.repositories;

import edu_school21_chat.models.User;
import edu_school21_chat.app.Program;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private Connection connection;
    public UsersRepositoryJdbcImpl(Connection con)
    {connection = con;}
    public List<User> findAll(int page, int size) throws NotSavedSubEntityException
    {
        List<User> res = new ArrayList<>();
        List<User> lst = Program.getUsersFromDb(connection);
        System.out.println(lst.size());
        int pages = lst.size() / size;int start = size * page;
        if (pages < page)
            throw new NotSavedSubEntityException();
        else {
            for (int i = start;i<=start+size;i++)
            {
                res.add(lst.get(i));
            }
        }
        return res;
    }
}
