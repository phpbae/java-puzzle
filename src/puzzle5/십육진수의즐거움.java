package puzzle5;

public class 십육진수의즐거움 {

    // 16진수(Hex) 2개를 더해서, 16진수로 출력
    static public void print() {

        //한 비트를 부호 비트로 사용. 1 = 음수 0 = 양수
        //한 비트를 부호 비트로 사용하기 때문에, 31비트로 숫자를 표현
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabe));
        System.out.println("-889275714 : " + Integer.toHexString(-889275714)); // cafebabe


    }

    // 대문자 L 을 붙여서 Long 자료형이라는걸 명시해주면 부호확장으로 값이 바뀌는걸 막을수 있다.
    static public void print2() {
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabeL));
        System.out.println("3405691582 : " + Long.toHexString(3405691582L));
    }

    //추가
    static public void print3() {
        try{
            System.out.println("------추가");
            System.out.println("(int)Long.parseLong() : " + (int)Long.parseLong(Integer.toHexString(-889275714),16)); // -889275714
            System.out.println("Integer.parseUnsignedInt() : " + Integer.parseUnsignedInt("cafebabe", 16)); // -889275714
            System.out.println("-2147483648 hexString = " + Integer.toHexString(-2147483648));
            System.out.println("-2147483648 hexString -> decode = " + Integer.decode("-" + "0x" + Integer.toHexString(-2147483648))); // 여기서 -2147483647 만 되도 안된다 ㅋㅋㅋ
            System.out.println(Integer.parseInt("-" + Integer.toHexString(-2147483648), 16)); // -2147483648
            System.out.println("-2147483648 toString = " + Integer.toString(-2147483648, 16));
            System.out.println(Integer.parseInt(Integer.toString(-2147483648, 16), 16)); // -2147483648

            System.out.println("-889275714 HexString : " + Integer.toHexString(-889275714)); // cafebabe
            System.out.println("-889275714 toString : " + Integer.toString(-889275714, 16)); // -35014542
            System.out.println("-889275714 toString -> decode = " + Integer.decode("-" + "0x35014542"));

            // 왜? int 자료형의 표현범위는 -2147483648 ~ 2147483647  이거인데 왜 에러가 날까?
            // Integer.toHexString -> 16진수의 부호없는 정수로 반환.
            // Integer.decode() 내부를 보면, result = Integer.valueOf(nm.substring(index), radix); valueOf 메서드를 이용하여 처리한다. -> valueOf를 따라가면, Integer.valueOf(parseInt(s,radix)) 자 이렇게 parseInt 로 처리.
            // limit == -Integer.MAX_VALUE == -2147483647 // multmin == -134217727 (int multmin = limit / radix;  여기서는 radix = 16)
            // parseInt()가 부호있는 int를 취하고 toHexString이 부호없는 결과를 생성
            // System.out.println(Integer.decode("0x" + Integer.toHexString(-889275714))); //error 발생
            // System.out.println("-889275714 hexString -> decode = " + Integer.decode("-" + "0x" + Integer.toHexString(-889275714))); //error

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

}
