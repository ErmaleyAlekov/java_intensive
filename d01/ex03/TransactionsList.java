package ex03;

import java.util.UUID;

public interface TransactionsList 
{
    public class TransactionNotFoundException extends RuntimeException{}
	public void addTransaction(Transaction trans);
	public void deleteTransaction(UUID uuid) throws TransactionNotFoundException;
	public Transaction[] toArray();
}