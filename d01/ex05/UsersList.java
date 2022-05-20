package ex05;

public interface UsersList 
{
    public class  UserNotFoundException extends RuntimeException {}
    public void addUser(User user);
    public User getUserById(int id) throws UserNotFoundException;
    public User getUserByIndex(int index) throws UserNotFoundException;
    public int getNumberOfUsers();
}