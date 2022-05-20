package ex00;

public class User
{
    private String Name;
    private int Id;
    private int Balance;

    User(String name, int id, int balance)
    {
        if (name.equals("") == true)
        {throw new IllegalArgumentException("Blank string not good!");}
        else
        {Name = name;}
        if (id < 0)
        {throw new IllegalArgumentException("ID must be positive!");}
        else {Id = id;}
        if (balance < 0)
        {throw new IllegalArgumentException("Balance must be positive!");}
        else {Balance = balance;}
    }
    User(User obj)
    {Name = obj.getName();Id = obj.getId();Balance = obj.getBalance();}
    public String getName()
    {
        return Name;
    }
    public void setName(String str)
    {
        if (str.equals("") == true)
        {throw new IllegalArgumentException("Blank string not good!");}
        else
        {Name = str;}
    }
    public int getId()
    {
        return Id;
    }
    public void setId(int id)
    {
        if (id < 0)
        {throw new IllegalArgumentException("Id must be positive!");}
        else
        {Id = id;}
    }
    public int getBalance()
    {
        return Balance;
    }
    public void setBalance(int balance)
    {
        if (balance < 0)
        {throw new IllegalArgumentException("Id must be positive!");}
        else
        {Balance = balance;}
    }
    public void printUserInfo()
    {
        System.out.println("Name: " + Name);
        System.out.println("ID: " + Id);
        System.out.println("Balance: " + Balance);
    }
}