import java.util.Scanner;

import RomanConverter.*;

public class Calculator {

    final String PLUS = "+";
    final String MINUS = "-";
    final String MULT = "*";
    final String DIV = "/";

    public int getOperatorPosition(String input) {
        if (input.contains(PLUS)) {
            return input.indexOf(PLUS);
        }

        if (input.contains(MINUS)) {
            return input.indexOf(MINUS);
        }

        if (input.contains(MULT)) {
            return input.indexOf(MULT);
        }

        if (input.contains(DIV)) {
            return input.indexOf(DIV);
        }

        return -1;
    }

    public void processCalc(String input) {
        if (getOperatorPosition(input) == -1) {
            System.out.println("Калькулятор поддерживает только +,-,*,/");
            return;
        }

        String firstNumber = getFirstNumber(input);
        String operator = getOperator(input);
        String secondNumber = getSecondNumber(input);
        RomanConverter converter = new RomanConverter();

        if (converter.isRomanNumber(firstNumber) && converter.isRomanNumber(secondNumber)) {
            int intFirstNumber = converter.romanToInt(firstNumber);
            int intSecondNumber = converter.romanToInt(secondNumber);
            if (intFirstNumber < 1 || intFirstNumber > 10 || intSecondNumber < 1 || intSecondNumber > 10) {
                System.out.println("Пример может содержать числа от I до X");
                return;
            }

            String result = romanCalc(firstNumber, operator, secondNumber);
            System.out.println(result);

        } else {
            try {
                int intFirstNumber = Integer.parseInt(firstNumber);
                int intSecondNumber = Integer.parseInt(secondNumber);
                if (intFirstNumber < 1 || intFirstNumber > 10 || intSecondNumber < 1 || intSecondNumber > 10) {
                    System.out.println("Пример может содержать числа от 1 до 10");
                    return;
                }
                int result = normallyCalc(intFirstNumber, operator, intSecondNumber);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Пример может содержать числа от 1 до 10");
            }
        }
    }

    public String getFirstNumber(String input) {
        int operatorPosition = getOperatorPosition(input);
        return input.substring(0, operatorPosition).trim();
    }

    public String getOperator(String input) {
        int operatorPosition = getOperatorPosition(input);
        return input.substring(operatorPosition, operatorPosition + 1);
    }

    public String getSecondNumber(String input) {
        int operatorPosition = getOperatorPosition(input);
        return input.substring(operatorPosition + 1).trim();
    }

    public int normallyCalc(int firstNumber, String operator, int secondNumber) {
        if (operator.equals(PLUS)) {
            return firstNumber + secondNumber;
        }
        if (operator.equals(MINUS)) {
            return firstNumber - secondNumber;
        }
        if (operator.equals(MULT)) {
            return firstNumber * secondNumber;
        }
        if (operator.equals(DIV)) {
            return firstNumber / secondNumber;
        }
        return 0;
    }

    public String romanCalc(String firstNumber, String operator, String secondNumber) {
        RomanConverter converter = new RomanConverter();
        int arabianFirstNumber = converter.romanToInt(firstNumber);
        int arabianSecondNumber = converter.romanToInt(secondNumber);
        int result = normallyCalc(arabianFirstNumber, operator, arabianSecondNumber);
        return converter.intToRoman(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.print("Введите пример: ");

        String input = in.nextLine();
        calculator.processCalc(input);
    }
}
