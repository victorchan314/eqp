package eqp;

import java.util.Stack;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    private Stack<String> eq;

    private String[] operators = {"+", "-", "*", "/", "^", "(", ")"};
    private String x = "x";

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
        Stack<String> e = (Stack<String>) eq.clone();
        Stack<String> s = new Stack<>();
        while (!e.isEmpty()) {

        }
    }

    public void checkEquation(String e) {

    }

    private String clean(String o) {
        return o.replaceAll("\\s", "");
    }

    private void parse(String e, Stack s) {

    }

}
