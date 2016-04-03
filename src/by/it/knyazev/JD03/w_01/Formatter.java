package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mac on 02.04.16.
 */
public class Formatter {

    public static void Trash(List<String> list){
        try {
            fileFormatRemover(list);
            fileNumberRemover(list);
        }catch (Exception e){
            System.out.println("Formatter 01: \n" + e.getMessage());
        }
    }

    public static void invisibleFilesRemover(List<String> list){
        List<String> temp = new ArrayList<>(list);
        list.clear();
        for (int i = 0; i < temp.size(); i++) {
            try {
                if (temp.get(i).contains(".DS_Store")) {
                    //System.out.println(temp.get(i));
                }else {
                    list.add(temp.get(i));
                }
            }catch (Exception e){
                System.out.println("Formatter 02: \n" + e.getMessage());
            }
        }
    }

    public static void fileFormatRemover(List<String> list){
        List<String> temp = new ArrayList<>(list);
        list.clear();
        for (int i = 0; i < temp.size(); i++) {
            try {
                list.add(temp.get(i).replaceAll(Patterns.fileFormatRemover, ""));
            }catch (Exception e){
                System.out.println("Formatter 03: \n" + e.getMessage());
            }
        }
    }

    public static void fileNumberRemover(List<String> list){
        List<String> temp = new ArrayList<>(list);
        list.clear();
        Pattern pat = Pattern.compile(Patterns.fileNumberRemover);
        for (int i = 0; i < temp.size(); i++) {
            try {
                Matcher match = pat.matcher(temp.get(i));
                if (match.find()){
                    String s = temp.get(i).replaceAll(Patterns.fileNumberRemover, "");
                    list.add(s);
                }else {
                    list.add(temp.get(i));
                }
            }catch (Exception e){
                System.out.println("Formatter 04: \n" + e.getMessage());
            }
        }
    }

    public static void xfieldsGen(List<String> xfields, String folder){
        // "img1|/img/tables/Cordoba_kofe.jpg";
        List<String> temp = new ArrayList<>(xfields);
        xfields.clear();
        try {
            for (int i = 0; i < temp.size(); i++) {
                xfields.add("img1|/img/"+folder+"/"+temp.get(i));
            }
        }catch (Exception e){
            System.out.println("Formatter 05: \n" + e.getMessage());
        }

    }

    public static void titleGen(List<String> title){
        Trash(title);
        List<String> temp = new ArrayList<>(title);
        title.clear();
        try {
            Pattern pat = Pattern.compile(Patterns.titleGen);
            for (int i = 0; i < temp.size(); i++) {
                Matcher match = pat.matcher(temp.get(i));
                if (match.find()) {
                    String cap = temp.get(i).toUpperCase();
                    title.add(cap);
                }
                else {
                    String cap = temp.get(i).substring(0, 1).toUpperCase() + temp.get(i).substring(1);
                    title.add(cap);
                }
            }
        }catch (Exception e){
            System.out.println("Formatter 06: \n" + e.getMessage());
        }
    }

    public static void alt_nameGen(List<String> alt_name){
        Trash(alt_name);
    }
}
