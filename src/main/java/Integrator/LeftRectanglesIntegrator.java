package Integrator;

import math.Integral;

public class LeftRectanglesIntegrator extends Integrator {

    @Override
    double countIntegral(Integral integral, double n) {
        double a = integral.getLowerBound();//x0
        double b = integral.getUpperBound();//xn
        double h = Math.abs((b - a) / n);

        double sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += h * integral.function().apply(a + (i-1) * h);
        }

        return sum;
    }
}
