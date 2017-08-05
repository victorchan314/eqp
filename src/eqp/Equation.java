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
        Stack<Double> s = new Stack<>();
        while (!e.isEmpty()) {
            String t = e.remove();
            if (operators.containsKey(t)) {
                int nargs = operators.get(t);
                if (s.size() < nargs) {
                    throw new IllegalArgumentException("Not enough arguments passed");
                }
                double[] args = new double[nargs];
                for (int i = nargs - 1; i >= 0; i--) {
                    args[i] = s.pop();
                }
                s.push(evaluateOperator(t, args));
            } else if (t.equals(x)) {
                s.push(n);
            } else {
                s.push(Double.parseDouble(t));
            }
        }
        if (s.size() == 1) {
            return s.pop();
        } else {
            throw new IllegalArgumentException("Incorrect number of arguments passed");
        }
    }

    private double evaluateOperator(String operator, double[] args) {
        switch (operator) {
            case "+":
                return args[0] + args[1];
            case "-":
                return args[0] - args[1];
            case "*":
                return args[0] * args[1];
            case "/":
                return args[0] / args[1];
            case "^":
                return Math.pow(args[0], args[1]);
            default:
                throw new IllegalStateException("Invalid operation");
        }
    }

    public void checkEquation(String e) {

    }

    private String clean(String o) {
        return o.replaceAll("\\s", "");
    }

    private void parse(String e, ArrayDeque s) {
        for (int i = 0; i < e.length(); i++) {
            String t = Character.toString(e.charAt(i));
        }
    }

}
