package by.it.podelstchikova.matlab;

import by.it.podelstchikova.matlab.exception.BadOperationException;
import by.it.podelstchikova.matlab.exception.BadValueException;
import by.it.podelstchikova.matlab.exception.VariableNotDefinedException;
import by.it.podelstchikova.matlab.interfaces.VariableStorageDAO;
import by.it.podelstchikova.matlab.services.Parser;
import by.it.podelstchikova.matlab.services.VariableComparator;
import by.it.podelstchikova.matlab.services.VariableStorageMapImpl;
import by.it.podelstchikova.matlab.values.Value;
import by.it.podelstchikova.matlab.values.Variable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

public class ConsoleRunner {

    private VariableStorageDAO storage = new VariableStorageMapImpl();
    Parser parser = new Parser();

    public void execute() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, BadOperationException, BadValueException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        while (true){

            String line = bufferedReader.readLine();
            if ("q".equals(line.trim().toLowerCase())){
                System.out.println("Exit.. Thank you for using");
                bufferedReader.close();
                break;
            } else if ("printvar".equals(line.trim().toLowerCase())){
                for (Value v : storage.getAll()){
                    System.out.println(v.toString());
                }
            } else if ("sortvar".equals(line.trim().toLowerCase())){
                List<Value> varList = storage.getAll();
                Collections.sort(varList, new VariableComparator());
                for (Value v : varList){
                    System.out.println(v.toString());
                }

            }

            try{
                Value result = parser.parse(line, storage);
                if (result instanceof Variable){
                    storage.setVariable(result.getValue(), result);
                }
                if (result == null){
                    System.out.println("Result: " + null);
                }

            } catch (BadValueException e){
                System.out.println(e.getMessage());
            } catch (VariableNotDefinedException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
