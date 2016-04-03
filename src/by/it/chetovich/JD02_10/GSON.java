package by.it.chetovich.JD02_10;


import by.it.chetovich.JD02_09.manual.GetJAXB_Hospital;
import by.it.chetovich.JD02_09.manual.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * gson
 */
public class GSON {

    public static void main(String[] args) {
        //маршаллизация и демаршаллизация в/из JSON. Подготовим  обработчики.
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        /* Строка выше это кратко. Создадим еще один точно такой же обработчик json
        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder=builder.serializeNulls();        //в нем пишем что сериализуются null
        builder=builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson=builder.create();              //теперь строитель строит того же обработчика
        */

        // Создаем объект для тестов

        // получаем наш объект Hospital
        Hospital hospital = GetJAXB_Hospital.getHospital();

        //маршаллизация
        String json = gson.toJson(hospital);
        System.out.print(json);
        //демаршаллизация
            Hospital hospital2 = gson.fromJson(json, Hospital.class);
            System.out.print("\n\nhospital2 = " + hospital2.toString());



    }
}
