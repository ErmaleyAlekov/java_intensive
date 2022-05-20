package ex00;
import java.util.UUID;
public class Transaction
{
    private static UUID Id;
    private static User Recipient;
    private static User Sender;
    private static String Category;
    private static int Amount;
    private static boolean Status;

    Transaction(UUID id, User a,User b, String c, int amount)
    {
        Recipient = a;Sender = b;Id = id;
        if (c.equals("debits") == true || c.equals("credits") == true)
        {Category = c;}
        else
        {throw new IllegalArgumentException("string must be 'debits' or 'credits'!");}
        if (amount < 0)
        {throw new IllegalArgumentException("Amount must be positive!");}
        else
        {Amount = amount;}
        if (b.getBalance() >= amount)
        {b.setBalance(b.getBalance() - amount);a.setBalance(a.getBalance() + amount);Status = true;}
        else
        {System.err.println("Error transaction!");Status = false;}
    }
    Transaction(Transaction obj)
    {
        Id = obj.getUUID();
        Recipient = obj.getRecipeint();
        Sender = obj.getSender();
        Category = obj.getCategory();
        Amount = obj.getAmount();
    }
    public UUID getUUID()
    {return Id;}
    public void setUUID(UUID uuid)
    {
        Id = uuid;
    }
    public User getRecipeint()
    {return Recipient;}
    public void setRecipient(User obj)
    {Recipient = obj;}
    public User getSender()
    {return Sender;}
    public void setSender(User obj)
    {Sender = obj;}
    public String getCategory()
    {return Category;}
    public void setCategory(String str)
    {
        if (str.equals("debits") == true || str.equals("credits") == true)
        {Category = str;}
        else
        {throw new IllegalArgumentException("string must be 'debits' or 'credits'!");}
    }
    public int getAmount()
    {return Amount;}
    public void setAmount(int amount)
    {
        if (amount <= 0)
        {throw new IllegalArgumentException("Amount must be positive!");}
        else
        {Amount = amount;}
    }
    public void printTransactionInfo()
    {
        System.out.println("UUID: " + Id);
        System.out.println("Recipient: " + Recipient.getName());
        System.out.println("Sender: " + Sender.getName());
        System.out.println("Category: " + Category);
        System.out.println("Amount: " + Amount);
        System.out.println("Status: " + Status);
    }
}