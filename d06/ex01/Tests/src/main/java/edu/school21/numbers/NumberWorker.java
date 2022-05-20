package edu.school21.numbers;
public class NumberWorker
{
    public static boolean isPrime(int number) throws IllegalNumberException
    {
        if (number <= 0 || number == 1)
            throw new IllegalNumberException();
        for (int i =2;i<number /2;i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static int digitsSum(int number)
    {
        int res = 0;
        while (number > 0)
        {
            res +=number % 10;
            number = number / 10;
        }
        return res;
    }

}
