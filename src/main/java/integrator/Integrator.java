package Integrator;

import math.Integral;

public abstract class Integrator {

    public IntegralAnswer integrate(Integral integral, Double accuracy) {
        int n = 4;
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

    abstract double countIntegral(Integral integral, double n);

    public abstract String getTitle();

}
