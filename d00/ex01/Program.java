/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/19 18:04:35 by uterese           #+#    #+#             */
/*   Updated: 2022/04/19 18:04:35 by uterese          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package d00.ex01;
import java.util.Scanner;
public class Program 
{
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        try 
        {
            System.out.print("Enter number ->: ");
            int number = obj.nextInt();
            if (number < 2)
            {
                System.err.println("IllegalArgument!");
                obj.close();
                System.exit(-1);
            }
            int i = 1;
            for (int j = 2;j<=number / 2;j++,i++)
            {
                if (number % j == 0)
                {
                    System.out.printf("False %d", i);
                    obj.close();
                    return;
                }
            }
            System.out.printf("True %d", i);
        } 
        catch (Exception e)
        {
            System.err.println("IllegalArgument!");System.exit(-1);
        }
        obj.close();
        return;
    }
}
