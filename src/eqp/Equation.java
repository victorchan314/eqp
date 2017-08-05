package eqp;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by victorchan on 8/5/17.
 */
public class Equation {

    private String original;
    private String equation;
    private ArrayDeque<String> eq;

    private static final String x = "x";
    private static final HashMap<String, Integer[]> operators;
    static {
        operators = new HashMap<>();
        operators.put("+", new Integer[]{2, 2, 0});
        operators.put("-", new Integer[]{2, 2, 0});
        operators.put("*", new Integer[]{2, 2, 0});
        operators.put("/", new Integer[]{2, 2, 0});
        operators.put("^", new Integer[]{2, 1, 1});
    }
    private static final String operator = String.join("|", operators.keySet()) + "|\\(|\\)";
    private static final String equationSeparator = "(?<=(" + operator + ") | (?=" + operator + "))";

    private static final String Digits;
    private static final String HexDigits;
    private static final String Exp;
    private static final String fpRegex;
    static {
        Digits = "(\\p{Digit}+)";
        HexDigits = "(\\p{XDigit}+)";
        // an exponent is 'e' or 'E' followed by an optionally
// signed decimal integer.
        Exp = "[eE][+-]?" + Digits;
        fpRegex =
                ("[\\x00-\\x20]*" + // Optional leading "whitespace"
                        "[+-]?(" +         // Optional sign character
                        "NaN|" +           // "NaN" string
                        "Infinity|" +      // "Infinity" string
                        // A decimal floating-point string representing a finite positive
                        // number without a leading sign has at most five basic pieces:
                        // Digits . Digits ExponentPart FloatTypeSuffix
                        //
                        // Since this method allows integer-only strings as input
                        // in addition to strings of floating-point literals, the
                        // two sub-patterns below are simplifications of the grammar
                        // productions from the Java Language Specification, 2nd
                        // edition, section 3.10.2.
                        // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
                        "(((" + Digits + "(\\.)?(" + Digits + "?)(" + Exp + ")?)|" +
                        // . Digits ExponentPart_opt FloatTypeSuffix_opt
                        "(\\.(" + Digits + ")(" + Exp + ")?)|" +
                        // Hexadecimal strings
                        "((" +
                        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
                        "(0[xX]" + HexDigits + "(\\.)?)|" +
                        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
                        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
                        ")[pP][+-]?" + Digits + "))" +
                        "[fFdD]?))" +
                        "[\\x00-\\x20]*");// Optional trailing "whitespace"
    }


    public Equation(String e) {
        checkEquation(e);
        original = e;
        equation = clean(original);
        eq = new ArrayDeque<>();
        parse(equation.split(equationSeparator), eq);
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
                int nargs = operators.get(t)[0];
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

    private double evaluateOperator(String op, double[] args) {
        switch (op) {
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

    private void parse(String[] args, ArrayDeque eq) {
        Stack<String> operatorStack = new Stack<>();
        for (String t : args) {
            if (Pattern.matches(fpRegex, t)) {
                eq.add(Double.valueOf(t));
            } else if (operators.containsKey(t)) {

            } else if (t.equals("(")) {

            } else if (t.equals(")")) {

            } else {

            }
        }
    }

}
