import eqp.Equation;
/**
 * Created by victorchan on 8/5/17.
 */
public class Test {

    public static void main(String[] args) {
        String equation = "ln(e^x)";
        Equation e = new Equation(equation);
        System.out.println(e.evaluate(1));
        System.out.println(e.evaluate(5));
        System.out.println(e.evaluate(-2));
    }

}
