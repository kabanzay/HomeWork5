import OOPCalculator.CalculatorStringParser;
import OOPCalculator.Operations.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUnitTests {
    @Test(expected = ArithmeticException.class)
    public void checkExceptionDivideZero() {
        double num1 = 2;
        double num2 = 0;
        DivideOperation d = new DivideOperation(num1, num2);
        d.operate();
    }

    @Test
    public void checkValidOperations() {
        double num1 = 10;
        double num2 = 2;
        double resultSum = num1 + num2;
        double resultDivide = num1 / num2;
        double resultMinus = num1 - num2;
        double resultMultiply = num1 * num2;

        assertTrue(resultSum == new SumOperation(num1, num2).operate());
        assertTrue(resultDivide == new DivideOperation(num1, num2).operate());
        assertTrue(resultMinus == new MinusOperation(num1, num2).operate());
        assertTrue(resultMultiply == new MultiplyOperation(num1, num2).operate());
    }

    @Test
    public void checkReturnClassParser() {
        CalculatorStringParser calculatorStringParser = new CalculatorStringParser();
        assertTrue(calculatorStringParser.parse("2/3") instanceof DivideOperation);
        assertTrue(calculatorStringParser.parse("2+3") instanceof SumOperation);
        assertTrue(calculatorStringParser.parse("2-3") instanceof MinusOperation);
        assertTrue(calculatorStringParser.parse("2*3") instanceof MultiplyOperation);
    }

    @Test(expected = NumberFormatException.class)
    public void checkParseNumberFormatExceptionWrongInput() throws NumberFormatException {

        CalculatorStringParser calculatorStringParser = new CalculatorStringParser();
        calculatorStringParser.parse("2..3/4..6");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkParseIndexOutOfBoundsExceptionWrongInput() throws NumberFormatException {
        CalculatorStringParser calculatorStringParser = new CalculatorStringParser();
        calculatorStringParser.parse("2");
    }
}
