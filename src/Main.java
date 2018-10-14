import puzzle1.홀수확인;

public class Main {

    public static void main(String[] args) {

        /**
         * 홀수확인 : 2로 나눈 나머지가 1이면, 홀수
         * 나머지 연산(%) -> 나머지 연산의 결과는 왼쪽 피연산자의 부호와 같다.(-3%2 = -1, 3%2=1)
         */
        System.out.println("1번째 퍼즐 - 홀수 확인");

        System.out.println(홀수확인.isOdd(10)); //false
        System.out.println(홀수확인.isOdd(9)); //true
        // 음수인 경우? -> 음수가 들어오면 무조건 false를 리턴한다.
        System.out.println(홀수확인.isOdd(-9)); //false

        // 양수/음수를 구분해서 해도 가능하나 -> 짝수면 2로 나눈 나머지가 0이기 때문에 이를 이용하여 처리한다. 홀수면 0이 아닐테니.
        System.out.println(홀수확인.isOdd2(-9)); //true
        System.out.println(홀수확인.isOdd2(-8)); //false

        // 만약 성능이 중요하다면? 비트연산자를 이용
        System.out.println(홀수확인.isOdd3(-7)); //true
        System.out.println(홀수확인.isOdd3(-5)); //true
        System.out.println(홀수확인.isOdd3(7)); //true
        System.out.println(홀수확인.isOdd3(10)); //false

    }
}
