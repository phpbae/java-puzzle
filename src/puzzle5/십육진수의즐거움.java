package puzzle5;

public class 십육진수의즐거움 {

    // 16진수(Hex) 2개를 더해서, 16진수로 출력
    static public void print() {
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabe));
//        System.out.println(Long.decode("0xcafebabe"));
//        System.out.printf("%d", 0xcafebabe);
        System.out.println(Integer.toHexString(-889275714)); // cafebabe
        System.out.println(Long.decode("0xcafebabe")); // QWORD 값으로 나옴 ㅠㅠ
        System.out.println(Long.decode("0x" + Long.toHexString(0x100000000L)));
    }

    // 대문자 L 을 붙여서 Long 자료형이라는걸 명ㅅ기해주면 부호확장으로 값이 바뀌는걸 막을수 있다.
    static public void print2() {
        System.out.println("16진수의 즐거움 : " + Long.toHexString(0x100000000L + 0xcafebabeL));
    }

}
