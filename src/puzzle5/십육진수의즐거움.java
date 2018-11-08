package puzzle5;

public class 십육진수의즐거움 {

    // 16진수(Hex) 2개를 더해서, 16진수로 출력
    static public void print() {
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabe));
        System.out.println("-889275714 : " + Integer.toHexString(-889275714)); // cafebabe
        //한 비트를 부호 비트로 사용. 1 = 음수 0 = 양수
        //한 비트를 부호 비트로 사용하기 때문에, 31비트로 숫자를 표현
        System.out.println("-889275714 : " + Integer.toBinaryString(-889275714));
        System.out.println("숫자 더해서 : " + Long.toHexString(4294967296L + -889275714));
    }

    // 대문자 L 을 붙여서 Long 자료형이라는걸 명ㅅ기해주면 부호확장으로 값이 바뀌는걸 막을수 있다.
    static public void print2() {
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabeL));
        System.out.println("3405691582 : " + Long.toBinaryString(3405691582L));
        System.out.println("cafebabe : " + Long.decode("0xcafebabe"));
        System.out.println("100000000 : " + Long.decode("0x100000000"));
        System.out.println("숫자 더해서 : " + Long.toHexString(4294967296L + 3405691582L));
    }

}
