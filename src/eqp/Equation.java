package eqp;

import java.util.Stack;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    Stack<String> eq;

    public Equation(String e) {
        original = e;
        equation = clean(original);
        parse(equation, eq);
    }

    public String getEquation() {
        return equation;
    }

    public double evaluate(double n) {

    }

    private String clean(String o) {

    }

    private void parse(String e, Stack s) {

    }

}
