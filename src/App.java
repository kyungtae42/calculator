import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = null;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("사칙연산을 하시겠습니까? 혹은 원의 넓이를 계산하시겠습니까? (사칙연산은 1, 원의 넓이는 2)");
            int type = sc.nextInt();
            if (type == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner로 양의 정수를 입력받고 적합한 타입의 변수에 저장
                int var1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner로 양의 정수를 입력받고 적합한 타입의 변수에 저장
                int var2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입의 변수에 저장
                char operator = sc.next().charAt(0);
                Operator op;
                try {
                    switch (operator) {
                        case '+':
                            op = new AddOperator();
                            break;
                        case '-':
                            op = new SubtractOperator();
                            break;
                        case '*':
                            op = new MultiplyOperator();
                            break;
                        case '/':
                            if (var2 == 0) {
                                throw new BadRequest(Character.forDigit(var2, 10));
                            }
                            op = new DivideOperator();
                            break;
                        case '%':
                            op = new ModOperator();
                            break;
                        default:
                            throw new BadRequest(operator);
                    }
                    calculator = new AritihmeticCalculator(op);
                    double result = ((AritihmeticCalculator) calculator).calculate(var1, var2);
                    System.out.println("연산 결과 : " + result); // 연산 결과 출력
                    calculator.setResult(result); // 결과 큐에 값 저장
                } catch (BadRequest e) {
                    e.printError();
                    continue;
                }

            } else if (type == 2) {
                System.out.print("원의 반지름을 입력하세요: ");
                // Scanner로 양의 정수를 입력받고 적합한 타입의 변수에 저장
                int var = sc.nextInt();
                calculator = new CircleCalculator();

                double result = ((CircleCalculator) calculator).calculate(var);
                System.out.println(result);
                calculator.setResult(result);
            } else {
                System.out.println("올바른 값을 입력하세요");
                continue;
            }
            sc.nextLine(); // String형 remove에 입력이 스킵되는 현상 방지
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.nextLine();
            if (remove.equals("remove")) {
                calculator.removeResult();
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.nextLine();
            if (inquiry.equals("inquiry")) {
                calculator.inquiryResult();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}