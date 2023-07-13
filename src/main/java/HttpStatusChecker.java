import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

public class HttpStatusChecker {
    public String getStatusImage(int code ) throws HttpStatusException{
        String link = "https://http.cat/" + code + ".jpg";
        try {
            Jsoup.connect(link).ignoreContentType(true).execute();
        } catch (IOException e) {
            throw new HttpStatusException("Invalid status code", ((HttpStatusException) e).getStatusCode(), link );
            }
        return link;
    }

    public static void main(String[] args) {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        try{
            System.out.println(statusChecker.getStatusImage(200));
            System.out.println(statusChecker.getStatusImage(404));
            System.out.println(statusChecker.getStatusImage(100500));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
