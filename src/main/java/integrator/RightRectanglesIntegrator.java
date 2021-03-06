package integrator;

import math.Integral;

public class RightRectanglesIntegrator extends Integrator {

    @Override
    double countIntegral(Integral integral, double n) {
        double a = integral.getLowerBound();//x0
        double b = integral.getUpperBound();//xn
        double h = Math.abs((b - a) / n);
        double value = 0;

        for (double i = 1; i <= n; i++) {
            value += h * integral.function().apply(a + i * h);
        }

        return value;
    }

    @Override
    public String getTitle() {
        return "Метод правых прямоугольников";
    }
}
