/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/19 18:04:56 by uterese           #+#    #+#             */
/*   Updated: 2022/04/19 18:04:56 by uterese          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package d00.ex02;
import java.util.Scanner;
public class Program 
{
    public static boolean prime(int num)
    {
        if (num <= 0 || num == 1)
            return false;
        for (int j = 2;j<=num / 2;j++)
        {
            if (num % j == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        int res = 0;
        int lst = 0;
        while (lst != 42)
        {
            try
            {
                System.out.print("Enter query ->");
                lst = obj.nextInt();
                int buff = lst;
                int sum = 0;
                while (buff > 0)
                {   
                    sum +=buff % 10;
                    buff = buff / 10;
                }
                if (prime(sum) == true){
                    res++;
                }
            }
            catch (Exception e)
            {
                System.err.println("IllegalArgument!");
                obj.close();
                System.exit(-1);
            }
        }
        System.out.printf("Count of coffee - request - %d\n", res);
        obj.close();
    }
}
