import org.jsoup.HttpStatusException;

import java.util.Scanner;
public class HttpImageStatusCli {
    private static boolean isNumeric(String str) {
        if (str == null)
            return false;
        return str.matches("\\d+");
    }
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        String line = scanner.nextLine();
        while (!isNumeric(line)){
            System.out.println("Please enter valid number");
            line = scanner.nextLine();
        }
        int code = Integer.parseInt(line);
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
        try{
            HttpStatusChecker statusChecker = new HttpStatusChecker();
            statusChecker.getStatusImage(code);
            imageDownloader.downloadStatusImage(code);
        }catch(HttpStatusException e){
            System.out.println("There is not image for HTTP status "+ code);
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli imageStatusCli = new HttpImageStatusCli();
        imageStatusCli.askStatus();
    }
}
