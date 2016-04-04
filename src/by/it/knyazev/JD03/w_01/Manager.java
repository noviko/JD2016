package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mac on 02.04.16.
 */
public class Manager {

    public static Formatter formatter = new Formatter();

    public static List<String> temp;

    public static List<String> xfields;

    public static List<String> title;

    public static List<String> alt_name;

    public static String category;

    public static String folder;

    public static void Manager(String c, String f, List<String> list) throws SQLException {

        if (list.size() > 0){
            category = c;
            folder = f;
            formatter.invisibleFilesRemover(list);


            temp = new ArrayList<>(list);
            xfields = new ArrayList<>(list);
            title = new ArrayList<>(list);
            alt_name = new ArrayList<>(list);

            //System.out.println(xfields.size()+"\n"+title.size()+"\n"+alt_name.size()+"\n");

            formatter.xfieldsGen(xfields, folder);
            formatter.fileNumberRemover(title);
            formatter.titleGen(title);
            formatter.alt_nameGen(alt_name);

            CheckForRepeat();
            requestGen();
        }
        //System.out.println(xfields.size()+"\n"+title.size()+"\n"+alt_name.size()+"\n");
    }

    public static void CheckForRepeat() {
        for (int k = 0; k < 3 ; k++) {
            for (int i = 0; i < alt_name.size() ; i++) {
                Pattern pat = Pattern.compile(alt_name.get(i));
                for (int j = i; j < alt_name.size(); j++) {
                    String s = alt_name.get(j);
                    Matcher match = pat.matcher(s);
                    if (match.find() && (i != j)){
                        title.remove(j);
                        xfields.remove(j);
                        alt_name.remove(j);
                    }
                }
            }
        }
    }

    public static void requestGen() throws SQLException {
        String tempQuery = Patterns.query;
        for (int i = 0; i < xfields.size() - 1; i++) {
            tempQuery = tempQuery + "('1', '', '', '','"+Main.autor+"', '"+Main.date+"', '"+xfields.get(i)+"', '"+title.get(i)+"', '"+category+"', '"+alt_name.get(i)+"'),\n";
        }
        int z = xfields.size() - 1;
        tempQuery = tempQuery + "('1', '', '', '','"+Main.autor+"', '"+Main.date+"', '"+xfields.get(z)+"', '"+title.get(z)+"', '"+category+"', '"+alt_name.get(z)+"');\n\n";
        //System.out.println(tempQuery);
        Mysql.ExecuteUpdate(tempQuery);

    }


    public static void getIdCount() throws SQLException {
        int id = 0;
        ResultSet resSet = Mysql.statement.executeQuery("SELECT id FROM dle_post WHERE id = (SELECT MAX(id) FROM dle_post);");
        while (resSet.next()){
            id = resSet.getInt("id");
        }
        System.out.println(id);
        if (id > 2000) {
            if (id > 5000) Mysql.ExecuteUpdate("TRUNCATE TABLE dle_post");
            else {
                System.out.println("Truncate table? (Y\\N)");
                String scn = new Scanner(System.in).nextLine();
                if (scn.contains("Y")) Mysql.ExecuteUpdate("TRUNCATE TABLE dle_post");
            }
        }
        if (id > 5000) Mysql.ExecuteUpdate("TRUNCATE TABLE dle_post");
    }

}
