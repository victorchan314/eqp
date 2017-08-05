package eqp;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    private ArrayDeque<String> eq;

    private static final String x = "x";
    private static final HashMap<String, Integer> operators;
    static {
        operators = new HashMap<>();
        operators.put("+", 2);
        operators.put("-", 2);
        operators.put("*", 2);
        operators.put("/", 2);
        operators.put("^", 2);
    }

    public Equation(String e) {
        checkEquation(e);
        original = e;
        equation = clean(original);
        eq = new ArrayDeque<>();
        parse(equation, eq);
    }

    public String getEquation() {
        return equation;
    }

    public double evaluate(double n) {
        ArrayDeque<String> e = (ArrayDeque<String>) eq.clone();
        Stack<String> s = new Stack<>();
        while (!e.isEmpty()) {
            String t = e.pop();
            if (operators.containsKey(t)) {

            } else {
                s.push(t);
            }
        }
    }

    public void checkEquation(String e) {

    }

    private String clean(String o) {
        return o.replaceAll("\\s", "");
    }

    private void parse(String e, ArrayDeque s) {

    }

}
