package Task_1_3_Complex;

public class Complex {
    public static void main(String[] args) {

        ComplexMath number = new ComplexMath(10, 6);
        ComplexMath number2 = new ComplexMath(6, 6);

        ComplexMath.sum(number, number2);

        ComplexMath.subtraction(number, number2);

        ComplexMath.multiplication(number, number2);

        System.out.println(ComplexMath.division(number, number2));

        System.out.println(number.sin());

        System.out.println(number.cos());

        number.tan();

        number.ctg();

        System.out.println(number.module());

    }
}