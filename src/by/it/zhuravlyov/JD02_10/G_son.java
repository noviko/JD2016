package by.it.zhuravlyov.JD02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class G_son {
    public static void main(String[] args){
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Write2 write=new Write2("bmw",2005,"diesel","automate",20000);
        String json=gson.toJson(write);
        System.out.println(json);

        Write2 write22 =gson.fromJson(json,Write2.class);
        System.out.println("\n\nwrite2=" + write.toString());
    }
}
