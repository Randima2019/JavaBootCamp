package ValidateUrl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validateUrl {

    //This method use for validate this part ("https://")
    public static boolean validateUrl(String text){

       String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher= pattern.matcher(text);
        return matcher.find();

    }
    //This method use for validate this part ("www.example.com")
    public static boolean validateUrlSecond(String url){

        String urlRegex = "((http:\\/\\/|https:\\/\\/)?(www.)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(\\/([a-zA-Z-_\\/\\.0-9#:?=&;,]*)?)?)";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher= pattern.matcher(url);
        return matcher.find();

    }



    public static void main(String[] args) {

        String text = "https://www.google.lk/";
        System.out.println(validateUrl(text));

        String url = "https://www.google.com/";
        System.out.println(validateUrlSecond(url));

    }
}
