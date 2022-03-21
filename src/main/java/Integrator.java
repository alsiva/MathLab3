public class Integrator {

    public IntegralAnswer integrate(Integral integral, Double accuracy) {
        Integer parts = 1;
        Double integral1n, integral2n = area(integral, parts);
        double delta;
        Integer limit = (1 << 22);

        do {
            integral1n = integral2n;
            parts <<= 1;
            integral2n = area(integral, parts);
            delta = Math.abs(integral1n - integral2n) / 3;
        } while (delta > accuracy && parts < limit);

        if (parts.equals(limit)) {
            throw new RuntimeException("Integral is diverge!");
        }
        return new IntegralAnswer(integral2n, delta, parts);
    }


    private Double area(Integral integral, Integer parts) {

        Double area = 0.0;
        double step = integral.boundDifference() / parts;
        for (int i = 1; i <= parts; i++) {
            area += this.trapezoid(
                integral.function(),
                integral.getLowerBound() + (i - 1) * step,
                integral.getLowerBound() + i * step
            );
            if (area.isNaN() || area.isInfinite()) {
                throw new RuntimeException("Integral is diverge!");
            }
        }
        return area;
    }

    private Double trapezoid(Function function, Double a, Double b) {
        Double val1 = function.apply(a);
        if (val1.isNaN() || val1.isInfinite() && !a.equals(b)) {
            a += 0.000000001D;
        }
        Double val2 = function.apply(b);
        if (val2.isNaN() || val2.isInfinite() && !a.equals(b)) {
            b -= 0.000000001D;
        }
        return 0.5 * (b - a) * (function.apply(a) + function.apply(b));
    }
}