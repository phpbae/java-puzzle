package puzzle2;

import java.math.BigDecimal;

public class 변화를위한시간 {

	
	/**
	 * 1.10 달러 점화 플러그 구입. 지불을 2달러를 제시.
	 * 2.00 - 1.10 -> 받을 거스름 돈은?
	 */
	
	public static void printMoney() {
		double a = 2.00;
		double b = 1.10;
		System.out.println(a - b); // 0.90 ?

		// Java 에서 int, long 은 정수형이기 때문에, 소수점을 포함할 수 없다.
		int aa = (int) 2.1;
		int bb = (int) 1.0;
		System.out.println(aa - bb); // 1.1 ?
	}
	
	/**
	 * printf() 를 활용하여 0.90이 나오게 할 수 있다.
	 * 하지만, 좋은 방법은 아니다. 여전히 부동소수점 연산 + 반올림 되어서 출력이 될뿐 
	 */
	public static void printMoney2() {
		double a = 2.00;
		double b = 1.10;
		System.out.printf("%.2f \n", a-b);
	}
	
	/**
	 * int / long 정수 자료형을 이용하면 위와 같은 문제를 해결할 수 있다.
	 * 다만, int / long 같은 경우는 숫자 범위를 조심(오버플로우 발생)
	 */
	public static void printMoney3() {
		int a = 200;
		int b = 110;
		System.out.println(a-b + " cents");
	}
	
	/**
	 * BigDecimal 클래스 이용
	 */
	public static void printMoney4() {
		double a = 2.00;
		double b = 1.10;
		//주의 : 생성자에 매개변수로 입력한 값을 그대로 표현
		BigDecimal decimalDouble = new BigDecimal(b); // 1.10 = 1.100000000000000088817841970012523233890533447265625
		BigDecimal decimalString = new BigDecimal("2.00"); // String 생성자를 이용하자.
		System.out.println("decimalDouble : " + decimalDouble);
		System.out.println("decimalString : " + decimalString);
		System.out.println("2.00 - 1.10 = " + new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
	}
	
}
