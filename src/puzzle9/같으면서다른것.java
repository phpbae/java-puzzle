package puzzle9;

public class 같으면서다른것 {

    static public void print() {

        int x = 10;
        short i = 10;
//        long i = 10;

        x += i; // 복합 할당 연산자는 자동형변환이 일어난다.
        x = x + i;

        short y = 0;
        int j = 123456;

        y += j; // 자동 자료형 변환이 일어난다. (왼쪽 변수의 자료형으로 자동 변환 / 오버플로 발생)
        // y = y + j;

    }

}
