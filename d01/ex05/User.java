package ex05;

import java.util.UUID;

public class User
{
    private String Name;
    private int Id;
    private int Balance;
    private TransactionsLinkedList lst = new TransactionsLinkedList();

    User(String name, int balance)
    {
        if (name.equals("") == true)
        {throw new IllegalArgumentException("Blank string not good!");}
        else
        {Name = name;}
        if (balance < 0)
        {throw new IllegalArgumentException("Balance must be positive!");}
        else {Balance = balance;}
        Id = UserIdsGenerator.getInstance().generateId();
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
    public TransactionsLinkedList getTransactionList()
    {
        return lst;
    }
    public void setTransactionList(TransactionsLinkedList obj)
    {
        lst = obj;
    }
    public void addTransactionInList(Transaction obj)
    {
        lst.addTransaction(obj);
    }
    public Transaction[] getTransactionsArray()
    {
        return lst.toArray();
    }
    public void removeTrans(UUID id)
    {lst.deleteTransaction(id);}
    public Transaction[] getArrTransactions()
    {
        return lst.toArray();
    }
}