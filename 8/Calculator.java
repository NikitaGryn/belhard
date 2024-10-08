public class Calculator {
    public double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
        return numerator / denominator;
    }
}
