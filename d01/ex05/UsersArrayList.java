package ex05;
public class UsersArrayList implements UsersList
{
    private User Users[] = new User[10];
    private User buffer[];
    private int size = 10;
    private int numberOfUsers = 0;
    public void addUser(User user)
    {
        if (Users[size - 1] != null)
        {
            buffer = new User[size];
            buffer = Users;
            size = size * 2;
            Users = new User[size];
            for (int i = 0;i< buffer.length;i++)
            Users[i] = buffer[i];
        }
        Users[numberOfUsers] = user;
        numberOfUsers++;
    }
    public User getUserById(int id) throws UserNotFoundException
    {
        for (int i =0;i<Users.length;i++)
        {
            if (Users[i].getId() == id)
            {
                return Users[i];
            }
        }
        throw new UserNotFoundException();
    }
    public User getUserByIndex(int index) throws UserNotFoundException
    {
        try {
            if (Users[index] == null)
        {throw new UserNotFoundException();}
        else
        {return Users[index];}
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }
    public int getNumberOfUsers()
    {
        return numberOfUsers;
    }
    public User[] getUsers()
    {   
        return Users;
    }
}