package by.it.podelstchikova.matlab.interfaces;

import by.it.podelstchikova.matlab.values.Value;

public interface Calc {
    Value add(Value val1, Value val2);
    Value sub(Value val1, Value val2);
    Value mul(Value val1, Value val2);
    Value div(Value val1, Value val2);
}
