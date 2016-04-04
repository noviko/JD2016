package by.it.podelstchikova.matlab.services;


import by.it.podelstchikova.matlab.values.Value;

import java.util.Comparator;

public class VariableComparator implements Comparator<Value>{
    @Override
    public int compare(Value val1, Value val2) {
        return val1.getValue().compareTo(val2.getValue());
    }
}
