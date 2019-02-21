package puzzle8;

public class DosEquis {


    static public void print() {
        char x = 'X'; // 88
        int i = 0;

        final int ii = 0;

        System.out.println("DosEquis : " + (true ? x : 0)); // X
        System.out.println("DosEquis : " + (false ? i : x)); // 88

        System.out.println("DosEquis : " + (true ? x : 0)); // X
        System.out.println("DosEquis : " + (false ? ii : x)); // X


        /**
         * 여러 자료형을 혼합해서 연산하면 복잡
         * 조건 연산자 사용 시, 2번째 / 3번째 피연산자의 자료형을 일치시키고 사용하는게 좋음.
         * 1. 2번째 / 3번째 피연산자의 자료형이 같다면 해당 자료형으로 결과를 반환.
         * 2. byte, short, char -> 자료형이고 다른 하나가 저 3가지로 변환가능한 int 상수라면 저 3가지 자료형으로 결과를 반환.
         * 3. 위 2가지 조건이 아니라면, 이항 숫자 확산을 적용. 2번째 / 3번째 피연산자 중 큰 자료형으로 결과를 반환.
         */

    }

}
