package by.it.podelstchikova.matlab.interfaces;

import by.it.podelstchikova.matlab.values.Value;

import java.util.List;

public interface VariableStorageDAO {
    Value getVariable(String variableName);
    void setVariable(String variableName, Value value);
    List<Value> getAll();
}
