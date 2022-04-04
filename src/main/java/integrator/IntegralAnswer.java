package integrator;

public class IntegralAnswer {
    private final Double area;
    private final Double error;
    private final Integer parts;

    public IntegralAnswer(double area, double error, Integer parts) {
        this.area = area;
        this.parts = parts;
        this.error = error;
    }

    public double getArea() {
        return this.area;
    }

    public void showAnswer() {
        System.out.println("-----------------");
        System.out.println("Area = " + area);
        System.out.println("Error = " + error);
        System.out.println("Parts = " + parts);
        System.out.println("-----------------");
    }
}