package eqp;

import java.util.Stack;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    private Stack<String> eq;

    private String[] operators = {"+", "-", "*", "/"};

    public Equation(String e) {
        checkEquation(e);
        original = e;
        equation = clean(original);
        eq = new Stack<>();
        parse(equation, eq);
    }

    public String getEquation() {
        return equation;
    }

    public double evaluate(double n) {
        Stack<String> s = (Stack<String>) eq.clone();
    }

    public void checkEquation(String e) {

    }

    private String clean(String o) {
        return o.replaceAll("\\s", "");
    }

    private void parse(String e, Stack s) {

    }

}
