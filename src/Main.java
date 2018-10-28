import puzzle1.홀수확인;
import puzzle2.변화를위한시간;
import puzzle3.Logn자료형나눗셈;

public class Main {

    public static void main(String[] args) {

		/**
		 * 홀수확인 : 2로 나눈 나머지가 1이면, 홀수 나머지 연산(%) -> 나머지 연산의 결과는 왼쪽 피연산자의 부호와 같다.(-3%2 =
		 * -1, 3%2=1)
		 */
		System.out.println("1번째 퍼즐 - 홀수 확인");

		System.out.println(홀수확인.isOdd(10)); // false
		System.out.println(홀수확인.isOdd(9)); // true
		// 음수인 경우? -> 음수가 들어오면 무조건 false를 리턴한다.
		System.out.println(홀수확인.isOdd(-9)); // false

		// 양수/음수를 구분해서 해도 가능하나 -> 짝수면 2로 나눈 나머지가 0이기 때문에 이를 이용하여 처리한다. 홀수면 0이 아닐테니.
		System.out.println(홀수확인.isOdd2(-9)); // true
		System.out.println(홀수확인.isOdd2(-8)); // false

		// 만약 성능이 중요하다면? 비트연산자를 이용
		System.out.println(홀수확인.isOdd3(-7)); // true
		System.out.println(홀수확인.isOdd3(-5)); // true
		System.out.println(홀수확인.isOdd3(7)); // true
		System.out.println(홀수확인.isOdd3(10)); // false

		/**
		 * 변화를 위한 시간 : 2.00 - 1.10 = 0.90 ? double은 숫자를 최소자릿수로 출력. 
		 * 자바에서 모든 소수가 float 또는 double로 표현될 수 있는 것은 아님.
		 * 자바에서 float / double 자료형으로 정확한 연산을 수핼할 수 없으므로, 금융계산 및 정밀한 계산이 필요한 곳에서 사용하면 안된다.
		 * 자바에서는 이진부동소수점 연산을 사용 : 계산은 빠르지만, 미세한 오차가 있음. 오차가 없는 십진부동소수점연산도 존재하지만 자바에서는 미지원
		 * 정확한 연산값을 원하면, int/long/BigDecimal을 이용하자!
		 */
		변화를위한시간.printMoney(); //0.8999999999999999	
		변화를위한시간.printMoney2(); //0.90 printf() 이용
		변화를위한시간.printMoney3(); //int / long 이용해서 처리
		변화를위한시간.printMoney4(); //BigDecimal 클래스 이용


		/**
		 * Long 자료형 나눗셈
		 * Java 에서는 타깃 타이핑(Target Typing)을 지원하지 않는다.
		 * long a = int * int -> 최종 결과물이 long 자료형이라도 int 자료형 값을 long으로 먼저 변환해서 처리 하지않음.(연산을 한 뒤, long 자료형으로 변환)
		 * 큰 숫자값을 다룰 때는 항상 오버플로(overflow)를 주의! (표현범위를 넘어 의도와는 다른값이 저장되는 현상)
		 */

		// 연산이 int 자료형들 끼리 이루어 지면서, 오버플로가 발생을 해버림.
		Logn자료형나눗셈.longPrint(); // 5
		Logn자료형나눗셈.longPrint2(); // 1000

	}
}
