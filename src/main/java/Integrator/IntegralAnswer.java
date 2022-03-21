package Integrator;

public class IntegralAnswer {
    private final Double area, error;
    private final Integer parts;

    public IntegralAnswer(double area, double error, Integer parts) {
        this.parts = parts;
        this.area = area;
        this.error = error;
    }

    public Double area() {
        return this.area;
    }

    public Double error() {
        return this.error;
    }

    public Integer parts() {
        return this.parts;
    }

    public void showAnswer() {
        System.out.println("-----------------");
        System.out.println("Area = " + area);
        System.out.println("Error = " + error);
        System.out.println("Parts = " + parts);
        System.out.println("-----------------");
    }
}