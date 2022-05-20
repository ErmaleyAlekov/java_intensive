package ex00;
import java.util.UUID;
public class Program
{
    public static void main(String[] args) 
    {
        User a[] = new User[2];
        a[0] = new User("alex", 0, 100);
        a[1] = new User("nick", 1, 100);
        a[0].printUserInfo();
        a[1].printUserInfo();
        Transaction c = new Transaction(UUID.randomUUID(), a[0], a[1],"debits", 100);
        c.printTransactionInfo();
        a[0].printUserInfo();
        a[1].printUserInfo();
        Transaction b = new Transaction(UUID.randomUUID(), a[0], a[1],"debits", 100);
        b.printTransactionInfo();
        // User asd = new User("john", 3, -1);
        // Transaction bc = new Transaction(UUID.randomUUID(), a[0], a[1],"debits", -100);
    }
}