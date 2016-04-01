package by.it.novik.JD02_10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Runner {
    public static void main(String[] args) {
        Gson gs = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        Person person = new Person("Kevin", "Smith", 49, "engineer", "London,23 Black str.");
        String json = gs.toJson(person);

        System.out.println(json);

        Person person1 = gs.fromJson(json, Person.class);

        System.out.println(person1.toString());
    }
}
