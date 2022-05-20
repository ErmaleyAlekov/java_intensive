package edu_school21_printer.logic;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.FileWriter;
public class Logic 
{
  public Logic(String str1, String str2)
  {
    DENSITY = str1 + str2;
  }
    public char[][] readImage(String path,int scH, int scW) throws IOException 
    {
        BufferedImage image = ImageIO.read(new File("resources/it.bmp"));
        int height = image.getHeight() / scH;
        int width = image.getWidth() / scW;
        char[][] chars = new char[height][width];
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int colorRGB = 0;
            for (int k = 0; k < scH; k++)
              for (int p = 0; p < scW; p++)
                colorRGB += image.getRGB(j * scW + p, i * scH + k);
            Color color = new Color(colorRGB / (scH * scW));
            int brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
            chars[i][j] = getDensity(brightness);
          }
        }
        return chars;
      }
      static String DENSITY;
      static char getDensity(int value) 
      {
        int charValue = (int) Math.round(DENSITY.length() / 255.0 * value);
        charValue = Math.max(charValue, 0);
        charValue = Math.min(charValue, DENSITY.length() - 1);
        return DENSITY.charAt(charValue);
      }
      public void writeToConsole(char[][] chars) throws IOException {
        for (char[] row : chars) {
          String str = String.valueOf(row);
          System.out.println(str);
        }
      }
      public static void main(String[] args) 
      {
        if (args.length == 1)
        {
            String path = args[0];
            try {
              Logic a = new Logic("0",".");
              char[][] chars = a.readImage(path,1, 1);
              a.writeToConsole(chars);
            } catch (Exception e) {
              System.out.println("Error path to file!");
              System.exit(-1);
            }
        }
        else
        {
            System.out.println("Error arguments!");
            System.exit(-1);
        }
      }
}
