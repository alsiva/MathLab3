package Integrator;

import math.Integral;

public class TrapezoidIntegrator extends AbstractIntegrator {

    public IntegralAnswer integrate(Integral integral, Double accuracy) {
        int n = 4;//Количество начальных разбиений
        double prevIntegral, nextIntegral = countIntegral(integral, n);
        double delta;

        do {
            prevIntegral = nextIntegral;
            n *= 2;
            nextIntegral = countIntegral(integral, n);
            delta = Math.abs(nextIntegral - prevIntegral) / 3;

        } while (delta > accuracy);

        return new IntegralAnswer(nextIntegral, delta, n);
    }

    private double countIntegral(Integral integral, double n) {
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