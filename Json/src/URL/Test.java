package URL;

import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) {

        try {


            String url = "https://jsonplaceholder.typicode.com/albums";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'Get' to URL :" +url);
            System.out.println("Responce Code : " +responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) !=null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());



        }catch (Exception e){
            System.out.println(e);
        }
    }
}
