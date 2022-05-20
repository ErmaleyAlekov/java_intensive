/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/19 18:05:06 by uterese           #+#    #+#             */
/*   Updated: 2022/04/19 18:05:06 by uterese          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package d00.ex03;
import java.util.Scanner;
public class Program 
{
    public static String nextWeek = "";
    public static int numberWeek = 0;
    public static String Week1 = "Week 1";
    public static String Week2 = "Week 2";
    public static String Week3 = "Week 3";
    public static String Week4 = "Week 4";
    public static String Week5 = "Week 5";
    public static String Week6 = "Week 6";
    public static String Week7 = "Week 7";
    public static String Week8 = "Week 8";
    public static String Week9 = "Week 9";
    public static String Week10 = "Week 10";
    public static String Week11 = "Week 11";
    public static String Week12 = "Week 12";
    public static String Week13 = "Week 13";
    public static String Week14 = "Week 14";
    public static String Week15 = "Week 15";
    public static String Week16 = "Week 16";
    public static String Week17 = "Week 17";
    public static String Week18 = "Week 18";
    public static String one = " =>";
    public static String two = " ==>";
    public static String three = " ===>";
    public static String four = " ====>";
    public static String five = " =====>";
    public static String six = " ======>";
    public static String seven = " =======>";
    public static String eight = " ========>";
    public static String nine = " =========>";
    public static int strlen(char str[])
    {
        int i = 0;
        try
        {
            char buff;
            while (true)
            buff = str[i++];
        }
        catch(Exception e)
        {
            return i - 1;
        }
    }
    public static int strlen(String str)
    {
        char str2[] = str.toCharArray();
        int res = strlen(str2);
        return res;
    }
    public static void print_result()
    {
        if (Week1.equals("Week 1") == false)
        {System.out.println(Week1);}
        if (Week2.equals("Week 2") == false)
        {System.out.println(Week2);}
        if (Week3.equals("Week 3") == false)
        {System.out.println(Week3);}
        if (Week4.equals("Week 4") == false)
        {System.out.println(Week4);}
        if (Week5.equals("Week 5") == false)
        {System.out.println(Week5);}
        if (Week6.equals("Week 6") == false)
        {System.out.println(Week6);}
        if (Week7.equals("Week 7") == false)
        {System.out.println(Week7);}
        if (Week8.equals("Week 8") == false)
        {System.out.println(Week8);}
        if (Week9.equals("Week 9") == false)
        {System.out.println(Week9);}
        if (Week10.equals("Week 10") == false)
        {System.out.println(Week10);}
        if (Week11.equals("Week 11") == false)
        {System.out.println(Week11);}
        if (Week12.equals("Week 12") == false)
        {System.out.println(Week12);}
        if (Week13.equals("Week 13") == false)
        {System.out.println(Week13);}
        if (Week14.equals("Week 14") == false)
        {System.out.println(Week14);}
        if (Week15.equals("Week 15") == false)
        {System.out.println(Week15);}
        if (Week16.equals("Week 16") == false)
        {System.out.println(Week16);}
        if (Week17.equals("Week 17") == false)
        {System.out.println(Week17);}
        if (Week18.equals("Week 18") == false)
        {System.out.println(Week18);}
    }
    public static void fill(String str)
    {
        if (nextWeek == "Week 2")
        {Week1 += str;}
        if (nextWeek == "Week 3")
        {Week2 += str;}
        if (nextWeek == "Week 4")
        {Week3 += str;}
        if (nextWeek == "Week 5")
        {Week4 += str;}
        if (nextWeek == "Week 6")
        {Week5 += str;}
        if (nextWeek == "Week 7")
        {Week6 += str;}
        if (nextWeek == "Week 8")
        {Week7 += str;}
        if (nextWeek == "Week 9")
        {Week8 += str;}
        if (nextWeek == "Week 10")
        {Week9 += str;}
        if (nextWeek == "Week 11")
        {Week10 += str;}
        if (nextWeek == "Week 12")
        {Week11 += str;}
        if (nextWeek == "Week 13")
        {Week12 += str;}
        if (nextWeek == "Week 14")
        {Week13 += str;}
        if (nextWeek == "Week 15")
        {Week14 += str;}
        if (nextWeek == "Week 16")
        {Week15 += str;}
        if (nextWeek == "Week 17")
        {Week16 += str;}
        if (nextWeek == "Week 18")
        {Week17 += str;}
        if (nextWeek == "End")
        {Week18 += str;}
    }
    public static boolean check_week(String str)
    {
        int nw = 0;
        if (str.equals("Week 1") == true)
        {nextWeek = "Week 2";nw = 1; if (nw <= numberWeek){return false;}
            numberWeek = 1;return true;}
        if (str.equals("Week 2")== true)
        {nextWeek = "Week 3";nw = 2; if (nw <= numberWeek){return false;}
        numberWeek = 2;return true;}
        if (str.equals("Week 3")== true)
        {nextWeek = "Week 4";nw = 3; if (nw <= numberWeek){return false;}
        numberWeek = 3;return true;}
        if (str.equals("Week 4")== true)
        {nextWeek = "Week 5";nw = 4; if (nw <= numberWeek){return false;}
        numberWeek = 4;return true;}
        if (str.equals("Week 5")== true)
        {nextWeek = "Week 6";nw = 5; if (nw <= numberWeek){return false;}
        numberWeek = 5;return true;}
        if (str.equals("Week 6")== true)
        {nextWeek = "Week 7";nw = 6; if (nw <= numberWeek){return false;}
        numberWeek = 6;return true;}
        if (str.equals("Week 7")== true)
        {nextWeek = "Week 8";nw = 7; if (nw <= numberWeek){return false;}
        numberWeek = 7;return true;}
        if (str.equals("Week 8")== true)
        {nextWeek = "Week 9";nw = 8; if (nw <= numberWeek){return false;}
        numberWeek = 8;return true;}
        if (str.equals("Week 9")== true)
        {nextWeek = "Week 10";nw = 9; if (nw <= numberWeek){return false;}
        numberWeek = 9;return true;}
        if (str.equals("Week 10")== true)
        {nextWeek = "Week 11";nw = 10; if (nw <= numberWeek){return false;}
        numberWeek = 10;return true;}
        if (str.equals("Week 11")== true)
        {nextWeek = "Week 12";nw = 11; if (nw <= numberWeek){return false;}
        numberWeek = 11;return true;}
        if (str.equals("Week 12")== true)
        {nextWeek = "Week 13";nw = 12; if (nw <= numberWeek){return false;}
        numberWeek = 12;return true;}
        if (str.equals("Week 13")== true)
        {nextWeek = "Week 14";nw = 13; if (nw <= numberWeek){return false;}
        numberWeek = 13;return true;}
        if (str.equals("Week 14")== true)
        {nextWeek = "Week 15";nw = 14; if (nw <= numberWeek){return false;}
        numberWeek = 14;return true;}
        if (str.equals("Week 15")== true)
        {nextWeek = "Week 16";nw = 15; if (nw <= numberWeek){return false;}
        numberWeek = 15;return true;}
        if (str.equals("Week 16")== true)
        {nextWeek = "Week 17";nw = 16; if (nw <= numberWeek){return false;}
        numberWeek = 16;return true;}
        if (str.equals("Week 17")== true)
        {nextWeek = "Week 18";nw = 17; if (nw <= numberWeek){return false;}
        numberWeek = 17;return true;}
        if (str.equals("Week 18")== true)
        {nextWeek = "End";nw = 18; if (nw <= numberWeek){return false;}
        numberWeek = 18;return true;}
        return false;
    }
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        String lst = "";
        while (lst.equals("42") != true)
        {
            try
            {
                System.out.print("->");
                lst = obj.nextLine();
                if (lst.equals("42"))
                {break;}
                if (check_week(lst) == true)
                {
                    try 
                    {
                        int max = 9;
                        int buff = 0;
                        String in;
                        System.out.print("->");
                        in = obj.nextLine();
                        for (int k =0; k < strlen(in); k++)
                        {
                            if(Character.isDigit(in.charAt(k)))
                            {
                                buff = Character.getNumericValue(in.charAt(k));
                                if (buff < max)
                                {max = buff;}
                                
                            }
                            if ((!Character.isDigit(in.charAt(k)) && in.charAt(k) != ' ')||buff == 0)
                            {
                                System.err.println("IllegalArgument!");
                                System.exit(-1);
                            }
                        }
                        if(max == 9)
                        {fill(nine);}
                        if (max == 8)
                        {fill(eight);}
                        if (max == 7)
                        {fill(seven);}
                        if (max == 6)
                        {fill(six);}
                        if (max == 5)
                        {fill(five);}
                        if (max == 4)
                        {fill(four);}
                        if (max == 3)
                        {fill(three);}
                        if (max == 2)
                        {fill(two);}
                        if (max == 1)
                        {fill(one);}
                        if (nextWeek.equals("End") == true)
                        break;
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("IllegalArgument!1");
                        System.exit(-1);
                    }
                }
                else
                {
                    System.err.println("IllegalArgument!2");
                    System.exit(-1);
                }
            }
            catch (Exception e)
            {
                System.err.println("IllegalArgument!3");
                System.exit(-1);
            }
        }
        obj.close();
        print_result();
    }   
}
