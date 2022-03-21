package math;

public class Integral {

    private final Function function;
    private final double lowerBound;
    private final double upperBound;

    public Integral(Function function, double lowerBound, double upperBound) {
        this.function = function;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Function function() {
        return this.function;
    }

    public double getLowerBound() {
        return this.lowerBound;
    }

    public double getUpperBound() {
        return this.upperBound;
    }

}

