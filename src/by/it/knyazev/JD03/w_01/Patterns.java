package by.it.knyazev.JD03.w_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 03.04.16.
 */

public class Patterns {
    public static String fileFormatRemover = "[\\.][a-z]+";
    public static String titleGen = "[-]+|[0-9]+";
    public static String fileNumberRemover = "[\\_][0-9]+";
    public static String query = "REPLACE INTO `dle_post` (`approve`,`short_story`, `full_story`, `keywords`, `autor`, `date`, `xfields`, `title`, `category`, `alt_name`) VALUES\n";

    public static List<String> createT = new ArrayList<>();

    public static void createTfiller(){
        createT.add("SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";");
        createT.add("SET time_zone = \"+00:00\";\n");
        createT.add("CREATE TABLE IF NOT EXISTS `dle_post` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `autor` varchar(40) NOT NULL DEFAULT '',\n" +
                "  `date` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',\n" +
                "  `short_story` text NOT NULL,\n" +
                "  `full_story` text NOT NULL,\n" +
                "  `xfields` text NOT NULL,\n" +
                "  `title` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `descr` varchar(200) NOT NULL DEFAULT '',\n" +
                "  `keywords` text NOT NULL,\n" +
                "  `category` varchar(200) NOT NULL DEFAULT '0',\n" +
                "  `alt_name` varchar(200) NOT NULL DEFAULT '',\n" +
                "  `comm_num` mediumint(8) unsigned NOT NULL DEFAULT '0',\n" +
                "  `allow_comm` tinyint(1) NOT NULL DEFAULT '1',\n" +
                "  `allow_main` tinyint(1) unsigned NOT NULL DEFAULT '1',\n" +
                "  `approve` tinyint(1) NOT NULL DEFAULT '0',\n" +
                "  `fixed` tinyint(1) NOT NULL DEFAULT '0',\n" +
                "  `allow_br` tinyint(1) NOT NULL DEFAULT '1',\n" +
                "  `symbol` varchar(3) NOT NULL DEFAULT '',\n" +
                "  `tags` varchar(250) NOT NULL DEFAULT '',\n" +
                "  `metatitle` varchar(255) NOT NULL DEFAULT '',\n" +
                "\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  KEY `autor` (`autor`),\n" +
                "  KEY `alt_name` (`alt_name`),\n" +
                "  KEY `category` (`category`),\n" +
                "  KEY `approve` (`approve`),\n" +
                "  KEY `allow_main` (`allow_main`),\n" +
                "  KEY `date` (`date`),\n" +
                "  KEY `symbol` (`symbol`),\n" +
                "  KEY `comm_num` (`comm_num`),\n" +
                "  KEY `tags` (`tags`),\n" +
                "  KEY `fixed` (`fixed`),\n" +
                "  FULLTEXT KEY `short_story` (`short_story`,`full_story`,`xfields`,`title`)\n" +
                ") ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;");
    }

}
