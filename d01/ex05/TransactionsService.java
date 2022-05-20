package ex05;

import java.util.UUID;

public class TransactionsService
{
    private static UsersArrayList array = new UsersArrayList();
    private static TransactionsLinkedList array2 = new TransactionsLinkedList();
    public void addUserInService(User obj)
    {array.addUser(obj);}
    public int getUserBalance(int id)
    {return array.getUserById(id).getBalance();}
    public int getUserBalanceByIndex(int index)
    {return array.getUserByIndex(index).getBalance();}
    public void addTransaction(int idRecipient, int idSender, int amount)
    {
        Transaction trans = new Transaction(UUID.randomUUID(), array.getUserById(idRecipient),array.getUserById(idSender),"debits",amount);
        if (!trans.checkStatus())
        {array2.addTransaction(trans);}
        array.getUserById(idRecipient).addTransactionInList(trans);
        array.getUserById(idSender).addTransactionInList(trans);
    }
    public Transaction[] getUserTransactions(int id)
    {
        return array.getUserById(id).getTransactionsArray();
    }
    public void removeTransaction(UUID id, int ID)
    {
        array.getUserById(ID).removeTrans(id);
    }
    public Transaction[] checkValidTransactions()
    {
        return array2.toArray();
    }
    
}