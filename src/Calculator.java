import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator extends Exception {
    public Calculator() {

    }

    public abstract void inquiryResult();

    public abstract void setResult(double result);

    public abstract void removeResult();
}


class BadRequest extends Exception {
    char cause;
    public BadRequest(char cause) {
        this.cause = cause;
    }
    public void printError() {
        if(cause == '0') {
            System.out.println("0으로 나눌 수 없습니다.");
        } else {
            System.out.println("잘못된 연산자를 입력했습니다.");
        }
    }
}