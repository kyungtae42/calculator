import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator {
    private final Queue<Double> resultQueue; // .resultQueue로 직접 접근하는 행위 방지

    public Calculator() {
        resultQueue = new LinkedList<>();
    }
    public Queue<Double> getResultQueue() {
        return resultQueue;
    }
    public abstract void inquiryResult();

    public abstract void setResult(double result);

    public abstract void removeResult();
}