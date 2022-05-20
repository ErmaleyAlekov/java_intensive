package ex05;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList
{
    private Transaction array[] = new Transaction[10];
    private Transaction buffer[];
    private int size = 10;
    private int numberOfTransactions = 0;
    public void addTransaction(Transaction obj)
    {
        if (array[size - 1] != null)
        {
            buffer = new Transaction[size];
            buffer = array;
            size = size * 2;
            array = new Transaction[size];
            for (int i =0;i<buffer.length;i++)
            array[i] = buffer[i];
        }
        if (numberOfTransactions != 0)
        {array[numberOfTransactions -1].setNext(obj);}
        array[numberOfTransactions] = obj;
        numberOfTransactions++;
    }
    public void deleteTransaction(UUID id)
    {
        int l = 0;
        for (int i =0;array[i] != null;i++)
        {
            if (array[i].getUUID() == id)
            {
                array[i] = null;
                if (array[i +1] != null)
                {
                    for (int j = i;j<numberOfTransactions;j++)
                    {
                        array[j] = array[j+1];
                    }
                    array[numberOfTransactions] = null;
                    for (int k = numberOfTransactions - 1;k != -1;k--)
                    {if (l != 0) array[k].setNext(array[k+1]);l++;}
                    numberOfTransactions--;
                    array[numberOfTransactions - 1].setNext(null);
                    break;
                }
            }
        }
    }
    public Transaction getTransaction(UUID id) throws TransactionNotFoundException
    {for (int i = 0;array[i] != null;i++)
    {
        if (array[i].getUUID() == id)
        return array[i];
    }throw new TransactionNotFoundException();}
    public Transaction[] toArray()
    {
        return array;
    }
    public void printTransactionListInfo()
    {
        for (int i =0;array[i] != null;i++)
        {array[i].printTransactionInfo();}
    }
    public int getSizeOfList()
    {
        return size;
    }
    public int getNumberOfTransactions()
    {return numberOfTransactions;}
}