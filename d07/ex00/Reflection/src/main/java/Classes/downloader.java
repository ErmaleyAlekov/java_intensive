package Classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class downloader
{
    private String folderToDownloard;
    private String URL;
    private boolean status;
    public downloader()
    {
        folderToDownloard = "/home/ermaley/java_piscine/d07/ex00/Reflection/src/main/resources";
        URL = "https://projects.intra.42.fr/uploads/document/document/4214/it.bmp";
        status = false;
    }
    public downloader(String folder, String url)
    {
        folderToDownloard = folder;URL=url;status = false;
    }
    public void download(String filename) throws IOException
    {
        try
        {
            java.net.URL url = new URL(URL);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(folderToDownloard + "/" + filename);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
            status = true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public String toString()
    {
        return "folderToDownloard = "+folderToDownloard+" URL = "+ URL+" status = "+status;
    }
}
