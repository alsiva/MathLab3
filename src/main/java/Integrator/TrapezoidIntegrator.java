package Integrator;

import math.Integral;

public class TrapezoidIntegrator extends Integrator {

    @Override
    double countIntegral(Integral integral, double n) {
        double a = integral.getLowerBound();//x0
        double b = integral.getUpperBound();//xn
        double h = Math.abs((b - a) / n);

        double y0 = integral.function().apply(a);
        double yn = integral.function().apply(b);

        double sum = 0;
        for (int i = 1; i <= n-1; i++) {
            sum += integral.function().apply(a + i * h);
        }

        return (h/2) * (y0 + yn + 2 * sum);
    }

}