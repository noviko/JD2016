package by.it.podelstchikova.matlab;

import by.it.podelstchikova.matlab.exception.BadOperationException;
import by.it.podelstchikova.matlab.exception.BadValueException;
import by.it.podelstchikova.matlab.interfaces.Calc;
import by.it.podelstchikova.matlab.services.Calculator;
import by.it.podelstchikova.matlab.values.FloatValue;
import by.it.podelstchikova.matlab.values.MatrixValue;
import by.it.podelstchikova.matlab.values.Value;
import by.it.podelstchikova.matlab.values.VectorValue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] arg) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, BadOperationException, BadValueException {

        Value val1 = new FloatValue(0.2);
        Value val2 = new FloatValue(5.3);
        val1.getValue();


        Calc calc = new Calculator();
        Value result = calc.div(val1, val2);
        System.out.println(result.getValue());

        double[] d = {1,2,3};
        double[][] m = {{1,2},{3,4}};
        Value vector = new VectorValue(d);
        System.out.println(vector);
        Value matrix = new MatrixValue(m);
        System.out.println(matrix);
        System.out.println(val1);
        ConsoleRunner runner = new ConsoleRunner();
        runner.execute();



    }
}
