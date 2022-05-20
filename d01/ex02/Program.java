package ex02;
// import ex02.User;
public class Program
{
    public static void main(String[] args) 
    {
        User user1 = new User("Egor", 100);
        User user2 = new User("Anton", 100);
        User user3 = new User("Kesha", 100);
        User user4 = new User("Sasha", 100);
        User user5 = new User("Ruslan", 100);
        User user6 = new User("Igor", 100);
        User user7 = new User("Dima", 100);
        User user8 = new User("Alexey", 100);
        User user9 = new User("Masha", 100);
        User user10 = new User("Olya", 100);
        User user11 = new User("Nina",100);
        User user12 = new User("Zhenya", 100);
        User user13 = new User("Nelya", 100);
        User user14 = new User( "Helen", 100);
        UsersArrayList lst = new UsersArrayList();

        lst.addUser(user1);
        lst.addUser(user2);
        lst.addUser(user3);
        lst.addUser(user4);
        lst.addUser(user5);
        lst.addUser(user6);
        lst.addUser(user7);
        lst.addUser(user8);
        lst.addUser(user9);
        lst.addUser(user10);
        lst.addUser(user11);
        lst.addUser(user12);
        lst.addUser(user13);
        lst.addUser(user14);
        User array[] = lst.getUsers();
        System.out.println("Array size: "+array.length);
        for (int i = 0;array[i] != null; i++)
        {
            System.out.println(array[i].getName() + " " + array[i].getId());
        }
        System.out.println("User By Index 12: " +lst.getUserByIndex(12).getId());
        System.out.println("Number Of User: " + lst.getNumberOfUsers());
        // System.out.println("User By Index 15: " +lst.getUserByIndex(15).getId());
    }
}