package eqp;

import java.util.Stack;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    private Stack<String> eq;

    public Equation(String e) {
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

    private String clean(String o) {
        return o.replaceAll("\\s", "");
    }

    private void parse(String e, Stack s) {

    }

}
