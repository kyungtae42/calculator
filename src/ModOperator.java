public class ModOperator implements Operator {
    @Override
    public double calculate(int val1, int val2) {
        return val1 % val2;
    }
}
