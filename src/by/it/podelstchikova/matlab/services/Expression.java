package by.it.podelstchikova.matlab.services;

import by.it.podelstchikova.matlab.values.Operation;
import by.it.podelstchikova.matlab.values.Value;

public class Expression {

    public Expression(Value firstValue, Value secondValue, Operation operation){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    private Value firstValue;
    private Value secondValue;
    private Operation operation;

    public Value getFirstValue() {
        return firstValue;
    }

    public Value getSecondValue() {
        return secondValue;
    }

    public Operation getOperation() {
        return operation;
    }
}
