import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class RoyaleAPI {
    public static String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImNkNGVkZjU2LTBmOGQtNGIxNC05MGRjLTUwNzVlZGI5OGFmMCIsImlhdCI6MTY3NzU4MDMwOSwic3ViIjoiZGV2ZWxvcGVyLzZhMWM5MjQ0LTE5N2MtOGE3Ni01MjE3LTRiMmVkNDlhNGUxYiIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyI1MS4xNzEuMjEyLjI0MSJdLCJ0eXBlIjoiY2xpZW50In1dfQ.Vn2NSYn7-bD9XcwPiacEoaVb85cQ0Bmfw0dXPmzU7eeHPxqyMaBC_Ykt4W9dL3On-ceSbqm56Ps5jkA6L5m15Q";
    public static HttpURLConnection connection; //set up variable for URL connection
    public static void main(String[] args) throws IOException {
        String PlayerUsename;
        BufferedReader reader;
        String line;
        StringBuffer responseContent=new StringBuffer();
        URL url= new URL("https://api.clashroyale.com/v1/players/%238RL9UU8C2");
        connection= (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status = connection.getResponseCode();
        if (status>299){
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line=reader.readLine())!=null){
                responseContent.append(line);
            }
            reader.close();
        }
        else{
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line=reader.readLine())!=null){
                responseContent.append(line);
            }
            reader.close();
        }
        System.out.println(responseContent.toString());


    }
    public void GetUsername(String UserName){
        Scanner inputName= new Scanner(System.in);
        UserName=inputName.nextLine();
    }
}
