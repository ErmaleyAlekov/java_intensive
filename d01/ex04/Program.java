package ex04;
public class Program
{
    public static void main(String[] args) 
    {
        User a[] = new User[2];
        a[0] = new User("alex", 100);
        a[1] = new User("nick", 100);
        TransactionsService service = new TransactionsService();
        service.addUserInService(a[0]);
        service.addUserInService(a[1]);
        service.addTransaction(a[0].getId(), a[1].getId(), 20);
        service.addTransaction(a[0].getId(), a[1].getId(), 100);
        System.out.println("alex balance: " +service.getUserBalance(a[0].getId()));
        System.out.println("nick balance: "+service.getUserBalance(a[1].getId()));
        Transaction check[] = service.checkValidTransactions();
        for (int i = 0;check[i] != null;i++)
        {check[i].printTransactionInfo();}
    }
}