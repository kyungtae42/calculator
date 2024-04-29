public class DivideOperator implements Operator {
    @Override
    public double calculate(int val1, int val2) {
        return ((double) val1) / val2;
    }
}
