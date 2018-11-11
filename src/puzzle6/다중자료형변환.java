package puzzle6;

public class 다중자료형변환 {

    static public void print() {
        //변환과정 int -> byte -> char -> int
        //컴퓨터에서 음수를 표현하는 방법으로 대부분 2의 보수로 음수를 표현
        // 바이트로 변환 시, 하위비트 8개를 제외하고 모든비트를 버림.(명시적 형변환)
        // char 형변환 시, 문제가 발생 자바에서 유일하게 부호가 없는(음수가 없는) 자료형 -> 묵시적 형변환 후, 명시적 형변환이 일어난다. byte -> int -> char 로 됨
        // char은 2바이트이니, 16비트만 취하면. 1111111111111111 -> 부호가 없으니 이 값은 65535가 나온다.
        // char는 부호가 없기 때문에, long 에서 0의 확장이 일어나는거다(양수값이네? 그냥 0으로 채웡~)
        System.out.println("1 :" + Integer.toBinaryString(1)); // 00000000000000000000000000000001
        System.out.println("-1(2의보수) :" + Integer.toBinaryString(-1)); // 11111111111111111111111111111111
        System.out.println("다중자료형변환 : " +  (int) (char) (byte) -1); //65535
    }

    static public void print2() {
        //변환과정 int -> byte -> int -> long
        System.out.println("다중자료형변환 : " + (long) (int) (byte) -1);
    }
}
