import puzzle1.홀수확인;
import puzzle2.변화를위한시간;
import puzzle3.Logn자료형나눗셈;
import puzzle4.초등학교;
import puzzle5.십육진수의즐거움;
import puzzle6.다중자료형변환;

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


		/**
		 * 초등학교 수준의 문제
		 * long 자료형의 숫자를 나타낼 때는 절대 소문자 l 을 사용하지 말고 대문자 L을 사용!!
		 */
		초등학교.print();

		/**
		 * 16진수의 즐거움
		 * 10진수 음수는 뺄셈 기호가 앞에 있는지 확인하면 알 수 있음.
		 * 16진수 8진수 2진수 값은 상위 비트가 정의되면 음수로 인식(최상위부호비트 = MSB)
		 * MSB 0 = 양수 MSB 1 = 음수
		 * 혼합 자료형 연산 : long + int 이기 때문에, int -> long 으로 확장변환이 일어남 이때, 부호확장도 함께 일어남.
		 * 0x100000000L + 0xffffffffcafebabe
		 * 다양한 진법의 숫자를 함께 연산하지 말아야 한다.
		 */

		십육진수의즐거움.print();
		십육진수의즐거움.print2();


		/**
		 * 다중 자료형 변환
		 * long 8byte / int 4byte / short 2byte / byte 1byte
		 * char 2byte -> unsigned(부호없는)
		 * 부호가 있는 자료형 -> 부호확장 / 부호가 없는 자료형이면, 0의 확장이 일어남.
		 * 양수값의 부호 확장에는 상위자리를 0으로 채우면 되고, 음수값의 부호 확장에는 상위 자리를 1로 채우면 끝!!
		 * -1 : 32비트 = 11111111111111111111111111111111  -> 이걸 long 64비트로 확장하면? = 1111111111111111111111111111111111111111111111111111111111111111
		 */

		다중자료형변환.print(); //65535
		다중자료형변환.print2(); //-1

	}
}
