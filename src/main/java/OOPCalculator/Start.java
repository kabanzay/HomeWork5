package OOPCalculator;

public class Start {
    public static void main(String[] args) {
        CalculatorStringParser stringParser = new CalculatorStringParser();
        Calculator calculator = new Calculator(stringParser);
        calculator.calculate();
    }
}