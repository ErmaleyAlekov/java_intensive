package ex05;

public final class UserIdsGenerator
{
    private static volatile UserIdsGenerator instance;
    private int Id = 0;
    private UserIdsGenerator() {}
    public static UserIdsGenerator getInstance()
    {
        if (instance == null) synchronized (UserIdsGenerator.class)
        {
            if (instance == null)
            {
                instance = new UserIdsGenerator();
            }
        }
        return instance;
    }
    public int generateId()
    {
        Id += 1;
        return Id;
    }
}