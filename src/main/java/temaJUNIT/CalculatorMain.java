package temaJUNIT;

import java.util.ArrayList;
import java.util.List;
// clasa main
public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculator("9 km + 10 m - 10 m - 9 km + 1 mm"));
        System.out.println(calculator.calculator("1 km + 2 mm - 1 dm - 10 cm + 28 mm"));
        System.out.println(calculator.calculator("1 km - 2 dm -  3 m - 4 cm - 5 mm"));

    }
}

