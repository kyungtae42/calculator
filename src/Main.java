import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int index = 0;
        //double[] resultArray = new double[10];
        Queue<Double> resultQueue = new LinkedList<>();
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner로 양의 정수를 입력받고 적합한 타입의 변수에 저장
            int var1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner로 양의 정수를 입력받고 적합한 타입의 변수에 저장
            int var2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입의 변수에 저장
            char operator = sc.next().charAt(0);

            double result = 0; // 사칙연산 결과
            switch (operator) { // 사칙연산 기호에 맞는 연산 하기
                case '+':
                    result = var1 + var2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = var1 - var2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = var1 * var2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    if (var2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다."); // 0으로 나눗셈을 시도하면 처음으로 이동함
                        continue;
                    }
                    result = (double) var1 / var2;
                    System.out.println("결과: " + result);
                    break;
            }
            resultQueue.add(result); // 결과 큐에 값 저장
//            if (index >= resultArray.length) {
//                for (int i = 0; i < resultArray.length - 1; i++) {
//                    resultArray[i] = resultArray[i+1];
//                }
//                index = 9;
//            }
//            resultArray[index++] = result;
//            for (double num : resultArray) {
//                System.out.print("결과 배열: " + num + " ");
//            }
            sc.nextLine(); // String형 remove에 입력이 스킵되는 현상 방지
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.nextLine();
            if(remove.equals("remove")) {
                resultQueue.poll(); // 큐의 맨 앞에있는 값 삭제
            }
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.nextLine();
            if (inquiry.equals("inquiry")) {
                System.out.print("저장된 결과: ");
                for (int i = 0; i < resultQueue.size(); i++) {
                    double temp = resultQueue.poll(); // 맨 앞의 큐의 값을 리턴하고 삭제한다.
                    System.out.print(temp + " ");
                    resultQueue.add(temp);
                } // 큐의 사이즈만큼 삭제하고 삭제한 값을 다시 입력하는거 반복(결과적으로 같은 내용물의 큐가 됨)
                System.out.println();
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}