package ex05;

import java.util.Scanner;
import java.util.UUID;

public class Program
{
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
        TransactionsService service = new TransactionsService();
        Scanner in = new Scanner(System.in);
        String lst = "";
        if (args.length > 0 && args[0].equals("--profile=dev"))
        {
            while (lst.equals("7") != true)
            {
                menu.printDevMenu();
                System.out.print("->");
                try
                {
                    lst = in.nextLine();
                    if (lst.equals("1"))
                    {
                        System.out.println("Enter a user name.");
                        System.out.print("->");
                        try {
                            lst = in.nextLine();
                            String nick = lst;
                            System.out.println("Enter a user balance.");
                            System.out.print("->");
                            lst = in.nextLine();
                            int balance = Integer.parseInt(lst);
                            User a = new User(nick, balance);
                            service.addUserInService(a);
                            System.out.println("User add succesfull.");
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                        
                    }
                    if (lst.equals("2"))
                    {
                        System.out.println("Enter a user ID.");
                        System.out.print("->");
                        try {
                            int id = in.nextInt();
                            System.out.println("User balance: "+service.getUserBalance(id));
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                    if (lst.equals("3"))
                    {
                        try {
                            System.out.println("Enter a recipient user ID.");
                            System.out.print("->");
                            int rec = in.nextInt();
                            System.out.println("Enter a sender user ID.");
                            System.out.print("->");
                            int sender = in.nextInt();
                            System.out.println("Enter amount for transaction.");
                            System.out.print("->");
                            int amount = in.nextInt();
                            service.addTransaction(rec, sender, amount);
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                        
                    }
                    if (lst.equals("4"))
                    {
                        try {
                            System.out.println("Enter a user ID.");
                            System.out.print("->");
                            int id = in.nextInt();
                            Transaction arr[] = service.getUserTransactions(id);
                            for(int i = 0;arr[i] != null;i++)
                            {arr[i].printTransactionInfo();}
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                    if (lst.equals("5"))
                    {
                        try {
                            System.out.println("Enter UUID.");
                            System.out.print("->");
                            String str = in.nextLine();
                            System.out.println("Enter a user ID.");
                            System.out.print("->");
                            int id = in.nextInt();
                            UUID uuid = UUID.fromString(str);
                            service.removeTransaction(uuid, id);
                            System.out.println("Success.");
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                    if (lst.equals("6"))
                    {
                        try {
                            Transaction ar[] = service.checkValidTransactions();
                            for(int i=0;ar[i] != null;i++)
                            {
                                ar[i].printTransactionInfo();
                            }
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                }
                catch (Exception e)
                {
                    System.err.println("IllegalInput!");
                    System.exit(-1);
                }
            }
        }
        else
        {
            while (lst.equals("5") != true)
            {
                menu.printMenu();
                System.out.print("->");
                try
                {
                    lst = in.nextLine();
                    if (lst.equals("1"))
                    {
                        System.out.println("Enter a user name.");
                        System.out.print("->");
                        try {
                            lst = in.nextLine();
                            String nick = lst;
                            System.out.println("Enter a user balance.");
                            System.out.print("->");
                            lst = in.nextLine();
                            int balance = Integer.parseInt(lst);
                            User a = new User(nick, balance);
                            service.addUserInService(a);
                            System.out.println("User add succesfull.");
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                        
                    }
                    if (lst.equals("2"))
                    {
                        System.out.println("Enter a user ID.");
                        System.out.print("->");
                        try {
                            int id = in.nextInt();
                            System.out.println("User balance: "+service.getUserBalance(id));
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                    if (lst.equals("3"))
                    {
                        try {
                            System.out.println("Enter a recipient user ID.");
                            System.out.print("->");
                            int rec = in.nextInt();
                            System.out.println("Enter a sender user ID.");
                            System.out.print("->");
                            int sender = in.nextInt();
                            System.out.println("Enter amount for transaction.");
                            System.out.print("->");
                            int amount = in.nextInt();
                            service.addTransaction(rec, sender, amount);
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                    if (lst.equals("4"))
                    {
                        try {
                            System.out.println("Enter a user ID.");
                            System.out.print("->");
                            int id = in.nextInt();
                            Transaction arr[] = service.getUserTransactions(id);
                            for(int i = 0;arr[i] != null;i++)
                            {arr[i].printTransactionInfo();}
                        } catch (Exception e) {
                            System.err.println("IllegalInput!");
                            System.exit(-1);
                        }
                    }
                }
                catch (Exception e)
                {
                    System.err.println("IllegalInput!");
                    System.exit(-1);
                }
            }
        }
        in.close();
    }
}