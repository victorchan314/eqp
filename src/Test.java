import eqp.Equation;
/**
 * Created by victorchan on 8/5/17.
 */
public class Test {

    public static void main(String[] args) {
        String equation = "3 + 5";
        Equation e = new Equation(equation);
        e.evaluate(5);
    }

}
