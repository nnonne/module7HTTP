import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code){
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        try{
            String link = statusChecker.getStatusImage(code);
            InputStream inputStream = new URL(link).openStream();
            Files.copy(inputStream, Path.of("image" + code + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        httpStatusImageDownloader.downloadStatusImage(200);
        httpStatusImageDownloader.downloadStatusImage(404);
        httpStatusImageDownloader.downloadStatusImage(100500);
    }
}
