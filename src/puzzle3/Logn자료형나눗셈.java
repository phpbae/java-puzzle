package puzzle3;

public class Logn자료형나눗셈 {

    static public void longPrint() {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println("Long 자료형 나눗셈 : " + (MICROS_PER_DAY / MILLIS_PER_DAY));
    }

    /**
     * 자바에서 타깃 타이핑을 지원하지 않음.
     * 연산되는 숫자들을 long 자료형으로 만들어주면, 오버플로가 발생하지 않는다.
     */
    static public void longPrint2() {
        final long MICROS_PER_DAY = 24L * 60L * 60L * 1000L * 1000L;
        final long MILLIS_PER_DAY = 24L * 60L * 60L * 1000L;

        System.out.println("Long 자료형 나눗셈2 : " + (MICROS_PER_DAY / MILLIS_PER_DAY));
    }

}
