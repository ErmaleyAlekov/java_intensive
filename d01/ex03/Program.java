package ex03;
import java.util.UUID;
public class Program
{
    public static void main(String[] args) 
    {
        User a[] = new User[2];
        a[0] = new User("alex", 100);
        a[1] = new User("nick", 100);
        Transaction c = new Transaction(UUID.randomUUID(), a[0], a[1],"debits", 20);
        c.printTransactionInfo();
        Transaction b = new Transaction(UUID.randomUUID(), a[0], a[1],"debits", 20);
        b.printTransactionInfo();
        TransactionsLinkedList lst1 = new TransactionsLinkedList();
        lst1.addTransaction(c);
        lst1.addTransaction(b);
        System.out.println(lst1.getNumberOfTransactions());
        System.out.println("--------------------------------------------");
        Transaction n = lst1.getTransaction(c.getNext().getUUID());
        System.out.println("Next UUID: " + n.getUUID());
        a[0].setTransactionList(lst1);
        a[1].setTransactionList(lst1);
        lst1.deleteTransaction(b.getUUID());
        System.out.println("--------------------------------------------");
        lst1.printTransactionListInfo();
        System.out.println(lst1.getNumberOfTransactions());
        // n = lst1.getTransaction(c.getNext().getUUID());
        // System.out.println("Next UUID: " + n.getUUID());
    }
}