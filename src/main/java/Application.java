import integrator.*;
import math.Function;
import math.FunctionStorage;
import math.Integral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final List<Integrator> INTEGRATORS = List.of(
        new TrapezoidIntegrator(),
        new LeftRectanglesIntegrator(),
        new MiddleRectanglesIntegrator(),
        new RightRectanglesIntegrator()
    );

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static void main(String[] args) {
        FunctionStorage.writeFunctionsChoice();

        int index = readIndex();

        Function function = FunctionStorage.chooseFunction(index-1);

        double a = readDouble("Write a: ");
        double b = readDouble("Write b: ");
        Integral integral = new Integral(function, a, b);
        double accuracy = readAccuracy();
        double preciseAnswer = 0;

        double leftValue = integral.function().apply(b);
        double rightValue = integral.function().apply(a);

        double sum = leftValue - rightValue;

        System.out.println("Точное значение интеграла");
        System.out.println(sum);
        //Вычисление интеграла приближёнными методами

        System.out.println("Вычисление интеграла приближёнными методами");
        FunctionStorage.writeFunctionsChoice();
        int index1 = readIndex();
        Function function1 = FunctionStorage.chooseFunction(index1-1);
        Integral integral1 = new Integral(function1, a, b);


        for (Integrator integrator : INTEGRATORS) {
            System.out.println(integrator.getTitle());
            IntegralAnswer answer = integrator.integrate(integral1, accuracy);
            answer.showAnswer();
        }

    }

    private static int readIndex() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.err.println("Couldn't read index");
            }
        }
    }

    private static double readDouble(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Double.parseDouble(reader.readLine());
            } catch (IOException e) {
                System.err.println("Failed to read variable");
            }
        }
    }


    private static double readAccuracy() {
        while (true) {
            System.out.println("Set accuracy in interval [0, 1]");
            System.out.println("Or leave empty for default value 0.00001");

            try {
                String input = reader.readLine();
                if (input.isEmpty()) {
                    return 0.00001;
                }

                double accuracy = Double.parseDouble(input);

                if (0 <= accuracy && accuracy <= 1) {
                    return accuracy;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            } catch (NullPointerException npe) {
                System.err.println("Empty input");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
