import java.util.Arrays;
import java.util.List;

public class FunctionStorage {

    private static final List<Function> FUNCTIONS = Arrays.asList(
        new Function("sin(x) / x"),
        new Function("x^2"),
        new Function("log(abs(x))"),
        new Function("log(x)")
    );

    public static void writeFunctionsChoice() {
        System.out.println("Choose the equation from 1 to " + FUNCTIONS.size());

        for (int i = 0; i < FUNCTIONS.size(); i++) {
            System.out.println("[" + (i+1) + "]: " + FUNCTIONS.get(i).toString());
        }
    }

}
