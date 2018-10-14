package puzzle1;

public class 홀수확인 {


    /**
     * 정수값을 받아, 홀수 인지 확인을 한다.(2로 나눈 나머지가 0이 아니면 홀수다)
     * @param i
     * @return
     */
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }


    public static boolean isOdd2(int i) {
        return i % 2 != 0;
    }

    // 비트연산자 (AND 이용)
    public static boolean isOdd3(int i) {
        return (i & 1) != 0;
    }
}
