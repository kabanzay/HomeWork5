package OOPCalculator.Operations;

public class DivideOperation implements Operation {
    private Double num1, num2;

    public DivideOperation(Double num1, Double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Double operate() {
        return num1/num2;
    }
}

