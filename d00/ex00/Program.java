/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/19 18:04:19 by uterese           #+#    #+#             */
/*   Updated: 2022/04/19 18:04:19 by uterese          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package d00.ex00;
public class Program
{
    public static void main(String[] args)
    {
        int a = 123456;
        int res = 0;
        res +=a % 10;
        a = a / 10;
        res +=a % 10;
        a = a / 10;
        res +=a % 10;
        a = a / 10;
        res +=a % 10;
        a = a / 10;
        res +=a % 10;
        a = a / 10;
        res +=a % 10;
        a = a / 10;
        System.out.println(res);
    }
}