import java.util.LinkedList;
import java.util.Queue;

public class CircleCalculator extends Calculator {
    // static으로 선언하면 스택이 아닌 메소드 에어리어(힙)에 저장된다. 이 프로그램에선 계산 기능을 바꿀 때 마다 새 인스턴스를 생성하는데 만약 인스턴스 변수로 선언하면 초기화 할 때 마다 참조 주소가 바뀌면서 circleResultQueue의 값이 날아간다.
    // 반면에 static으로 선언하면 인스턴스와 별개로 저장되기 때문에 같은 CircleCalculator 클래스라면 모두 circleResultQueue의 값을 공유하기 때문에 값이 날아가지 않는다.
    public CircleCalculator() {
        //circleResultQueue = new LinkedList<>();
    }
    public double calculate(double val) {
        double result = 0;
        result = val*val*Math.PI;
        return result;
    }
    @Override
    public void setResult(double result) {
        getResultQueue().add(result);
    }
    @Override
    public void inquiryResult() {
        System.out.print("저장된 결과: ");
        for (int i = 0; i < getResultQueue().size(); i++) {
            double temp = getResultQueue().poll(); // 맨 앞의 큐의 값을 리턴하고 삭제한다.
            System.out.print(temp + " ");
            getResultQueue().add(temp);
        } // 큐의 사이즈만큼 삭제하고 삭제한 값을 다시 입력하는거 반복(결과적으로 같은 내용물의 큐가 됨)
        System.out.println();
    }
    @Override
    public void removeResult() {
        getResultQueue().poll(); // 큐의 맨 앞에있는 값 삭제
    }
}
