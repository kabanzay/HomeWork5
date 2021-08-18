package OOPCalculator;

import OOPCalculator.Operations.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringParser {
    public Operation parse(String request) {
        double firstValue = 0, secondValue=0;
        String operation;
        //избавимся от лишних пробелов
        request = request.trim();
        //отделим цифры
        try {
            String[] array = request.split("[+\\-\\/*]");
            //распарсим String  в double
            firstValue = Double.parseDouble(array[0]);
            secondValue = Double.parseDouble(array[1]);
        }catch (NumberFormatException|ArrayIndexOutOfBoundsException e){
            System.out.println("Невозможно корректно распарсить строку. Возможно вы ввели что-то не так");
            e.printStackTrace();
            System.exit(1);
        }
        //определим операцию
        Pattern p = Pattern.compile("[+\\-\\/*]");
        Matcher m = p.matcher(request);
        if (m.find()) {
            operation = m.group(0);
            if ("+".equals(operation)) {
                return new SumOperation(firstValue, secondValue);
            } else if ("-".equals(operation)) {
                return new MinusOperation(firstValue, secondValue);
            } else if ("/".equals(operation)) {
                return new DivideOperation(firstValue, secondValue);
            } else if ("*".equals(operation)) {
                return new MultiplyOperation(firstValue, secondValue);
            }
        }
        System.out.println("Операция отсутствует");
        return null;
    }
}

