# java-puzzle
자바 퍼즐러 코드 작성


#### 1. 홀수확인

- 나머지 연산을 사용할 때는 항상 피연산자의 부호와 결과가 어떻게 나올지 생각을 해야함.
```
확인하고자 하는 숫자를 2로 나눈 나머지가 1이면 홀수.

하지만, 나머지 연산의 결과는 항상 왼쪽 피연산자 부호와 같다.
- 3%2 = 1
- 3%-2 = -1
- -3%2 = -1

i % 2 == 1  -> 음수 홀수값이 들어오는 경우 항상 false를 리턴.

i % 2 != 0 -> 음수 홀수값이 들어와도 정상적인 결과를 리턴.

만약, 성능까지 고려한다면 비트연산자를 이용.
입력 숫자 n에서 홀수, 짝수를 결정 하는 것은 마지막 자리 숫자
ex 1)
10 이라는 10진수 정수를 예로 들면
10은 2진수로 표현하면 1010 이고,
1은 2진수로 그냥 1이다.
10 & 1 은 1010 & 1과 동일함.

1010
   1
그럼 1010의 마지막 자리는 0 이고, 0과 1을 &(논리곱) 연산 하면 0 이기 때문에
짝수가 된다. 1과 논리곱 연산을 했으니 false가 나온다.

비트 논리곱(&)은 비트 단위로 논리곱 연산을 합니다. 
예를 들어 6&5를 하면 
6은 이진수로 110, 
5는 이진수로 101, 
이므로 6&5의 연산 결과는 이진수 100로 10진수 4입니다.

110
101
100 -> 2^2 = 4
```

#### 2. 변화를 위한 시간

- 자바는 float / double 자료형으로 정확한 연산을 수행할 수 없음.
- 자바는 이진 부동소수점 연산을 사용. -> 빠르지만, 미세한 오차가 있음
- 오차가 없는 십진 부동소수점 연산도 존재하지만, 자바 기본 자료형 연산에서 이를 지원X
- 정확한 결과가 필요하다면, float / double 자료형을 사용하지 말고 int, long, BigDecimal 자료형을 사용. 
```

double a = 2.00;
double b = 1.10;
System.out.println(a - b); // 0.90 ?
결과 : 0.8999999999999999 
이진 부동소수점 연산을 사용하기 떄문에, 미세한 오차가 발생.  따라서, 금융 계산에서 사용하면 큰일.


//주의 : 생성자에 매개변수로 입력한 값을 그대로 표현
BigDecimal decimalDouble = new BigDecimal(b); // 1.10 = 1.100000000000000088817841970012523233890533447265625
BigDecimal decimalString = new BigDecimal("2.00"); // String 생성자를 이용하자.

decimalDouble : 1.100000000000000088817841970012523233890533447265625
decimalString : 2.00

System.out.println("2.00 - 1.10 = " + new BigDecimal("2.00").subtract(new BigDecimal("1.10")));

결과 : 2.00 - 1.10 = 0.90
```


#### 3. Long 자료형 나눗셈

- Java 에서는 타깃 타이핑(Target Typing)을 지원하지 않는다.
- long a = int * int -> 최종 결과물이 long 자료형이라도 int 자료형 값을 long으로 먼저 변환해서 처리 하지않음.(연산을 한 뒤, long 자료형으로 변환)
- 큰 숫자값을 다룰 때는 항상 오버플로(overflow)를 주의! (표현범위를 넘어 의도와는 다른값이 저장되는 현상)


```
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

        // 위와 동일한 결과를 얻을 수 있다. 이유는 연산 시, 묵시적 형변환을 해준다. 밑에 24L은 long 인데 뒤에 오는 피연사자는 int다 int -> long 자동형변환이 일어난다.
        //final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        //final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;


        System.out.println("Long 자료형 나눗셈2 : " + (MICROS_PER_DAY / MILLIS_PER_DAY));
    }
```


#### 4. 초등학교 수준의 문제

- long 자료형의 숫자를 나타낼 때는 절대 소문자 l 을 사용하지 말고 대문자 L을 사용!!

```
    /**
     * 초등학교 수준의 문제
     * 66666 ?
     * 1 l 혼동될수도 있다. 일부 폰트에서는 구분하기 어려움
     *
     */

    static public void print() {
        System.out.println(12345 + 5432l);

        System.out.println(12345 + 5432L);
    }
```

#### 5. 16진수의 즐거움

- 10진수 음수는 뺄셈 기호가 앞에 있는지 확인하면 알 수 있음.
- 16진수 8진수 2진수 값은 상위 비트가 정의되면 음수로 인식(최상위부호비트 = MSB)
- MSB 0 = 양수 MSB 1 = 음수
- 혼합 자료형 연산 : long + int 이기 때문에, int -> long 으로 확장변환(묵시적 형변환)이 일어남 이때, 부호확장도 함께 일어남. (0x100000000L + 0xffffffffcafebabe)
- toHexString() 는 부호없는 결과를 생성 / parseInt()가 부호있는 int를 결과로 생성.
- API 문서를 보면, decodable string 이라는 용어가 있는데, 부호를 따로 표기하거나 생략하라고 되어있다.
- DecodableString: 
  Signopt DecimalNumeral / Signopt 0x HexDigits / Signopt 0X HexDigits / Signopt # HexDigits / Signopt 0 OctalDigits
- Sign: - / +
- 다양한 진법의 숫자를 함께 연산하지 말아야 한다.

```
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
```

#### 6. 다중자료형변환

- long 8byte / int 4byte / short 2byte / byte 1byte
- char 2byte -> unsigned(부호없는)
- 부호가 있는 자료형 -> 부호확장 / 부호가 없는 자료형이면, 0의 확장이 일어남.
- 양수값의 부호 확장에는 상위자리를 0으로 채우면 되고, 음수값의 부호 확장에는 상위 자리를 1로 채우면 끝!!
- 컴퓨터에서는 음수값을 표현하기 위해, 대부분 2의 보수를 이용한다.
- -1 : 32비트 = 11111111111111111111111111111111  -> 이걸 long 64비트로 확장하면? = 1111111111111111111111111111111111111111111111111111111111111111

```
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
```