package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

public class Patterns {
    public static String fileFormatRemover = "[\\.][a-z]+";
    public static String titleGen = "[-]+|[0-9]+";
    public static String fileNumberRemover = "[\\_][0-9]+";
    public static String query = "REPLACE INTO `dle_post` (`approve`,`short_story`, `full_story`, `keywords`, `autor`, `date`, `xfields`, `title`, `category`, `alt_name`) VALUES\n";


}
