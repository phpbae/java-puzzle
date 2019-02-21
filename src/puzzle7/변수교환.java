package puzzle7;

public class 변수교환 {

    // 배타적 논리합 (XOR)
    // 1 이 나오는 경우, 두 비트의 값이 다를 경우. 같으면 0
    // 1100 ^ 1000 =  0100
    static public void print() {
        int x = 1984;
        int y = 2001;

        //2진수 : 11111000000
        System.out.println("1984 HexString : " + Integer.toHexString(1984)); //7c0
        //2진수 : 11111010001
        System.out.println("2001 HexString : " + Integer.toHexString(2001)); //7d1

        //11111000000
        //11111010001
        //00000010001
        // x ^ y = 17 (10001)

        x ^= y ^= x ^= y;  //x 와 y를 교환.
        //자바는 피연산자를 왼쪽에서 오른쪽으로 계산.
        // x ^ = expr 형태의 표현식을 계산 시, x는 expr이 계산되기전에 추출되고 expr이 계산된 이후에 합쳐진다.
        System.out.println("x = " + x); //0
        System.out.println("y = " + y); //1984

        /**
         * // 자바 순서
         * x ^= y ^= x ^= y;
         * int tmp1 = x; //1984
         * int tmp2 = y; //2001
         * int tmp3 = x ^ y;  // x ^ y 계산 (여기선 17)
         * x = tmp3; //  x ^ y 계산을 x에 넣음 //17
         * y = tmp2 ^ tmp3; // 원래 x를 y에 저장 //2001 ^ 17 = 1984
         * x = tmp1 ^ y; // x에 0을 저장 //1984 ^ 1984 = 0
         */


        int x2 = 1984;
        int y2 = 2001;
        x2 = x2 ^ y2;
        y2 = x2 ^ y2;
        x2 = y2 ^ x2;
        System.out.println("x2 = " + x2); //2001
        System.out.println("y2 = " + y2); //1984


        /**
         * 추가적인 변수 없이 두 변수를 교환하는 방법(사용X)
         * CPU 메모리도 많아졌고, 논리합이 3개나 있으니 이해하기도 힘들고, 컴파일러에 따라 제대로 작동하지 않는 경우도 있음
         */
        //x = x ^ y;
        //y = y ^ x;
        //x = y ^ x;

    }
}
