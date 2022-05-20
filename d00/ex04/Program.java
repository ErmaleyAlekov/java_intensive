/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/19 18:05:14 by uterese           #+#    #+#             */
/*   Updated: 2022/04/19 18:05:14 by uterese          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package d00.ex04;
import java.util.Scanner;
public class Program 
{
    public static int[] resetCount() 
    {
        int[] Count = new int[65535];
        for (int i = 0; i < 65535; i++) 
        {
            Count[i] = 0;
        }
        return Count;
    }

    static int[] getCount(String inputString, int size) 
    {
        int[] Count = resetCount();
        char[] inputArray = inputString.toCharArray();
        for (int i = 0; i < size; i++) {
            char ch = inputArray[i];
            Count[ch]++;
        }
        return Count;
    }

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

    static int[][] getStats(String inputString, int size) 
    {
        int[] Count = getCount(inputString, size);
        int[][] StatsTemp = new int[size][2];
        int charIndex = 0;
        for (int i = 0; i < 65535; i++) 
        {
            if (Count[i] > 0) 
            {
                StatsTemp[charIndex][0] = i;
                StatsTemp[charIndex][1] = Count[i];
                charIndex++;
            }
        }
        int[][] Stats = new int[charIndex][2];
        for (int i = 0; i < charIndex; i++) 
        {
            Stats[i][0] = StatsTemp[i][0];
            Stats[i][1] = StatsTemp[i][1];
        }
        return Stats;
    }

    static boolean smaller(int[] item1, int[] item2) 
    {
        if (item1[1] < item2[1])
            return true;
        if (item1[1] == item2[1]) {
            char char1 = (char) item1[0];
            char char2 = (char) item2[0];
            return char1 > char2;
        }
        return false;
    }

    static int[][] sortStats(int[][] Stats) 
    {
        for (int i = 1; i < Stats.length; i++) 
        {
            for (int j = i; j > 0 && smaller(Stats[j - 1], Stats[j]); j--) 
            {
                int tmpChar = Stats[j - 1][0];
                int tmpCount = Stats[j - 1][1];
                Stats[j - 1][0] = Stats[j][0];
                Stats[j - 1][1] = Stats[j][1];
                Stats[j][0] = tmpChar;
                Stats[j][1] = tmpCount;
            }
        }
        return Stats;
    }

    static int[][] preparePrint(int[][] Stats, int printSize) 
    {
        int[][] stats = new int[printSize][3];
        int max = Stats[0][1];
        for (int i = 0; i < printSize; i++) 
        {
            stats[i][0] = Stats[i][0];
            stats[i][1] = Stats[i][1];
            stats[i][2] = ((10 * Stats[i][1])) / (max);
        }
        return stats;
    }

    static void printStats(int[][] sortedStats, int printSize) 
    {
        int[][] stats = preparePrint(sortedStats, printSize);
        String[][] print = new String[printSize][12];
        for (int i = 0; i < printSize; i++) 
        {
            print[i][0] = "  " + (char) (stats[i][0]);
            for (int j = 0; j < stats[i][2]; j++) {
                print[i][1 + j] = "  #";
            }
            if (stats[i][1] >= 100) {
                print[i][1 + stats[i][2]] = "" + stats[i][1];
            }
            else if (stats[i][1] >= 10) {
                print[i][1 + stats[i][2]] = " " + stats[i][1];
            }
            else {
                print[i][1 + stats[i][2]] = "  " + stats[i][1];
            }
            for (int j = 2 + stats[i][2]; j < 12; j++) {
                print[i][j] = "";
            }
        }
        for (int j = 11; j >= 0; j--) 
        {
            for (int i = 0; i < printSize; i++) {
                System.out.print(print[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner obj = new Scanner(System.in);
        try
        {
            System.out.print("->");
            String str = obj.nextLine();
            int size = strlen(str);
            if (size > 0 && size < 999) 
            {
                int[][] stats = getStats(str, size);
                int[][] sortedStats = sortStats(stats);
                int printSize = sortedStats.length;
                if (printSize > 10)
                    printSize = 10;
                printStats(sortedStats, printSize);
            }
            else
            {
                System.err.println("IllegalArgument!");
                System.exit(-1);
            }
        }
        catch(Exception e)
        {
            System.err.println("IllegalArgument!");
            System.exit(-1);
        }
        obj.close();
    }
}