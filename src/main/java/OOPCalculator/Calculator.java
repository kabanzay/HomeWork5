package OOPCalculator;

import OOPCalculator.Operations.Operation;

import java.util.Scanner;

public class Calculator {
    private CalculatorStringParser calculatorStringParser;

    public Calculator(CalculatorStringParser calculatorStringParser) {
        this.calculatorStringParser = calculatorStringParser;
    }

    public void calculate() {
        System.out.println("Введите выражение состоящее из 2-х дробных чисел и +,-,/,*");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Operation operation = calculatorStringParser.parse(input);
        System.out.printf("%.4f",operation.operate());

    }
}
