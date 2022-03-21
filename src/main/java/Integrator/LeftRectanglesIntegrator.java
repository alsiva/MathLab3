package Integrator;

import math.Integral;

public class LeftRectanglesIntegrator extends Integrator {

    @Override
    double countIntegral(Integral integral, double n) {
        double a = integral.getLowerBound();//x0
        double b = integral.getUpperBound();//xn
        double h = Math.abs((b - a) / n);
        double value = 0;

        for (int i = 1; i <= n; i++) {
            value += h * integral.function().apply((i-1) * h);
        }

        return value;
    }
}
