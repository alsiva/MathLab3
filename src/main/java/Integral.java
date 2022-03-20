public class Integral {
    private final Function function;
    private final Bounds bounds;

    public Integral(Function function) {
        this.function = function;
        this.bounds = new Bounds();
    }

    public Integral from(Double lowerBound) {
        bounds.lowerBound = lowerBound;
        return this;
    }

    public Integral to(Double upperBound) {
        bounds.upperBound = upperBound;
        return this;
    }

    public Function function() {
        return this.function;
    }

    public Bounds bounds() {
        return this.bounds;
    }

    public static class Bounds {
        protected Double lowerBound;
        protected Double upperBound;

        public Boolean equal() {
            return this.lowerBound.equals(this.upperBound);
        }

        public Double difference() {
            return this.upperBound - this.lowerBound;
        }

        public Double lower() {
            return this.lowerBound;
        }

        public Double upper() {
            return this.upperBound;
        }
    }

}

