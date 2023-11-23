package case_study_furama_resort.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean checkRegexStr(String regex, String path){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        return matcher.matches();
    }
}
