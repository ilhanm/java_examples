import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkRepeatedMoreThanXTimes {

    /*
    * https://stackoverflow.com/questions/1660694/regular-expression-to-match-any-character-being-repeated-more-than-10-times
    *
    * */

    public static final Pattern IS_REPEATED_MORE_THAN_2_TIMES_REGEX = Pattern.compile("(.)\\1{2,}");

    public static boolean validate(String stringToCheck){
        Matcher matcher = IS_REPEATED_MORE_THAN_2_TIMES_REGEX.matcher(stringToCheck);
        return matcher.find();
    }

    public static void main(String[] args){
        System.out.println(validate("merhabaaa"));
        System.out.println(validate("merhaba"));
    }

}
