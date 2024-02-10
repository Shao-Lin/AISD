package Task_1_3_Complex;

public class ComplexMath {
    private double real;
    private double imaginary;

    public ComplexMath(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexMath(ComplexMath division) {
        System.out.println(division);
    }

    public String toString() {
        if (imaginary < 0)
            return real + "" + imaginary + "i";
        if (real == 0)
            return imaginary + "i";
        if (imaginary == 0)
            return real + "";
        return real + "+" + imaginary + "i";
    }

    public static void sum(ComplexMath number, ComplexMath number2) {
        ComplexMath result = new ComplexMath(number.real + number2.real, number.imaginary + number2.imaginary);
        System.out.println(result);
    }

    public static void subtraction(ComplexMath number, ComplexMath number2) {
        ComplexMath result = new ComplexMath(number.real - number2.real, number.imaginary - number2.imaginary);
        System.out.println(result);
    }

    public static void multiplication(ComplexMath number, ComplexMath number2) {
        ComplexMath result = new ComplexMath(number.real * number2.real - number.imaginary * number2.imaginary,
                number.imaginary * number2.real + number.real * number2.imaginary);
        System.out.println(result);
    }

    public static ComplexMath division(ComplexMath number, ComplexMath number2) {
        double ac = number.real * number2.real;
        double bd = number.imaginary * number2.imaginary;
        double bc = number.imaginary * number2.real;
        double ad = number.real * number2.imaginary;
        double realNum = (ac + bd) / (Math.pow(number2.real, 2) + Math.pow(number2.imaginary, 2));
        double imagNum = (bc - ad) / (Math.pow(number2.real, 2) + Math.pow(number2.imaginary, 2));
        ComplexMath result = new ComplexMath(realNum, imagNum);
        return result;
    }

    public ComplexMath sin() {
        return new ComplexMath(Math.sin(this.real) * Math.cosh(this.imaginary), Math.cos(this.real) * Math.sinh(this.real));

    }

    public ComplexMath cos() {
        return new ComplexMath(Math.cos(this.real) * Math.cosh(this.imaginary), Math.sin(this.real) * Math.sinh(this.imaginary));

    }
    public ComplexMath tan() {
        return new ComplexMath(ComplexMath.division(sin(),cos()));
    }

    public ComplexMath ctg() {
        return new ComplexMath(ComplexMath.division(cos(),sin()));
    }
    public ComplexMath module(){
        return new ComplexMath(Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2)),0);
    }
}