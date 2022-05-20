package ex05;

public class  Menu 
{
    public void printMenu()
    {
        for (int i = 0;i<20;i++)
        {System.out.print("-");}
        System.out.println("");
        System.out.println("1. Add user.");
        System.out.println("2. View user balances.");
        System.out.println("3. Perform a transfer.");
        System.out.println("4. View all transactions for a specific user.");
        System.out.println("5. Finish execution.");
        for (int i = 0;i<20;i++)
        {System.out.print("-");}
        System.out.println("");
    }
    public void printDevMenu()
    {
        for (int i = 0;i<20;i++)
        {System.out.print("-");}
        System.out.println("");
        System.out.println("1. Add user.");
        System.out.println("2. View user balances.");
        System.out.println("3. Perform a transfer.");
        System.out.println("4. View all transactions for a specific user.");
        System.out.println("5. DEV - remove a transfer by ID.");
        System.out.println("6. DEV - check transfer validity.");
        System.out.println("7. Finish execution.");
        for (int i = 0;i<20;i++)
        {System.out.print("-");}
        System.out.println("");
    }
}
