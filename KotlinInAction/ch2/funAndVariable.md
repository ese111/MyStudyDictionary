# Kotlin in Action
## 1. 함수와 변수
### 아무런 값을 반화하지 않는 함수
- fun을 사용
- 파라미터 뒤에 타입 지정
- 클래스가 없어도 정의 가능
- 배열처리를 위한 문법이 따로 없이 배열도 일반 클래스와 마찬가지
- System.out.println이 아닌 println 사용
- 표준 자바 라이브러리를 간결하게 쓸 수 있게 감싼 래퍼 제공
- ; 없음
```kotlin
fun main(args: Array<String>) {
    println("Hello, world!!")
}
```
### 반환값이 있는 함수
- :뒤에 리턴 타입을 쓴다.
- 루프를 제외한 거의 모든 제어구조가 식

```kotlin
fun max(a:Int, b: Int): Int{
   return if(a>b) a else b
}
fun main(args: Array<String>) {
    println(max(1, 2))
}
```
- 식으로 간결하게 함수를 표현 가능
```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
```
- 컴파일러가 함수 본문식을 분석해서 타입을 자동 지정(타입 추론)

### 변수
- 타입 생략가능
    - 타입으로 변수 선언을 하면 식과 구분이 힘들어지는 것을 방지
- 초기화식을 분석해서 자동 타입 설정
```kotlin
val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
val answer: Int = 42
```
- 초기화 식이 없다면 타입을 정해야함
```kotlin
val yearToCompute = 7.5e6  // <---- 7.5 x 10^6 = 7500000.0
val answer: Int
answer = 42
```
- val
    - 변경 불가한 참조를 저장
    - 초기화 후 재대입 불가
    - final
    - 객체 자체의 값은 변경가능
    ex)
    ```kotlin
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    ```
    ex) 오류
    ```kotlin
    var answer = 42
    answer = "no answer"
    ```
- var
    - 변경 가능한 참조 저장
    - 일반 변수
변수의 기본은 val으로 하고 필요할때 var변경하면 함수형 코드에 가까워진다.
```kotlin
val msg: String
if (canPerformOperation()){
    msg = "Success"
}else{
    msg = "Failed"
}
```
### 문자열 템플릿
- $로 문자열에 변수를 사용가능
- ${}를 습관화해주자
- $를 쓰고 싶으면 \를 사용
```kotlin
fun main(args: Array<String>) {
    println("\$x")
    val name = if(args.size > 0) args[0] else "Kotlin"
    println("Hello, ${name}!!")
    println("Hello, ${if(args.size > 0) args[0] else "someone"}!")
}
```
## 2. 클래스와 프로퍼티
- java의 필드
```java
public class Person{
    private final String name;
}
public Person(String name){
    this.name = name;
}
public String getName(){
    return name;
}
```
- 코틀린의 필드 대입
    - 값 객체 사용
    - 가시성 변경자 없음(public)
```kotlin
class Person(val name: String)
```
### 프로퍼티
- 코틀린은 프로퍼티를 기본 제공
- 자바의 필드와 접근자 메소드를 대신함
- 클래스에서 프로퍼티 선언시 val, var 선언
```kotlin
class Person{
    val name: String // 읽기 전용
    var isMarried: Boolean // 사용 가능
}
```
- 비공개 필드와 그 필드에 값을 저장하기 위한 세터, 필드의 값을 읽기 위한 게터로 이뤄진 간단한 디폴트 접근자 구현을 제공
- 비공개 필드에 자바와 같은 구현이 있어서 자바와 동일 한방식으로도 사용가능
```java
Person person = new person("Bob", true);
System.out.println(person.getName());
System.out.println(person.isMarried());
```
- java에서 is가 붙은 게터를 쓰면 ()를 붙여야함(isMarried())
```kotlin
val person = Person("Bob", true)
println(person.name())
println(person.isMarried())
```
- 변경
    - java
    ```java
    person.setMarried(false)
    ```
    - kotlin
    ```kotlin
    person.isMarried = false
    ```
- 자바에서 선언한 클래스에서 코틀린 문법을 사용가능
- 커스텀 게터로 프로퍼티 값을 그때그때 계산 가능
### 커스텀 접근자
```kotlin
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
    get(){
        return height == width
    }
}
fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
```
- 파라미터가 없는 함수를 정의하는 방식과 커스텀 게터와는 성능 차이는 없음
### 디렉토리와 패키지
- 패키지
    - 파일 맨 앞에 package문을 넣으면 그 파일 안에 모든 선언이 패키지로 들어감
    - 같은 패키지면 선언 사용가능
    - 다른 패키지의 선언은 임포트 후 사용
    - *을 쓰면 최상위에 정의된 함수나 프로퍼티까지 모두 불러옴
    - 자바와 다르게 한 파일에 여러 클래스를 넣을 수 있고 이름도 마음대로 가능
    - 소스코드파일을 디렉토리도 아무곳이나 위치해도 됨
    - 지비처럼 페키지별로 구성하는 것 추천(협업)
    
```kotlin
package kotlinInAction.shapes

import java.util.*

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
```

## 선택 표현과 처리: enum과 when
- when은 switch와 대치
### enum 클래스
- 소프트 키워드(이름에 사용 가능)
- class는 사용 불가
- 프로퍼티나 메소드도 정의 가능
```kotlin
enum class Color(
    val r: Int, val g: Int, val b: Int
){
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);
    fun rgb() = (r * 256 + g ) * 256 + b
}
fun main(args: Array<String>) {
    println(Color.BLUE.rgb())
}
```
### when
- when도 식
```kotlin
fun getMnemonic(color: Color) = when(color){
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vain"
}
fun main(args: Array<String>) {
    println(getMnemonic(Color.BLUE))
}
```
- break를 넣지 않아도 됨
- 여러 값을 매치 패턴으로 사용 할땐 , 사용
```kotlin
fun getWarmth(color: Color) = when(color){
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}
fun main(args: Array<String>) {
    println(getWarmth(Color.BLUE))
}
```
- import를 통해서 Color없이 사용
```kotlin
package kotlinInAction.ch02.GetWarmth

import kotlinInAction.ch02.colors.Color.Color
import kotlinInAction.ch02.colors.Color.Color.*

fun getWarmth(color: Color) = when(color){
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun main() {
    getWarmth(RED)
}
```
- 분기 조건에 다른 객체도 사용 가능
```kotlin
fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
       setOf(RED, YELLOW) -> ORANGE
       setOf(YELLOW, BLUE) -> GREEN
       setOf(BLUE, VIOLET) -> INDIGO
       else -> throw Exception("Dirty color")
    }
fun main() {
    println(mix(BLUE, YELLOW))
}
```
## 스카트 캐스트
- is는 타입을 검사하는 함수
- is를 쓰면 자동으로 타입을 캐스팅해줌
    - ex) e is Num 후에 e를 자동으로 Num으로 캐스팅해줌
- 커스텀 접근자 x
- 프로퍼티가 val만 가능
```kotlin
interface Expr
class Num(val value: Int) : Expr
class Sum(val right: Expr, val left: Expr) : Expr
fun eval(e: Expr): Int{
    if(e is Num){
        val n= e as Num
        return n.value
    }
    if(e is Sum){
        return eval(e.right)+ eval(e.left)
    }
    throw IllegalArgumentException("Unknown")
}
fun main() {
    println(eval(Sum(Sum(Num(1),Num(2)), Num(4))))
}
```
### when으로 리팩토링
- if를 식으로
```kotlin
fun eval(e: Expr): Int = if (e is Num) { e.value } else if (e is Sum) { eval2(e.left) + eval2(e.right) } else { throw java.lang.IllegalArgumentException("Unknown expression") }
```
- when으로
```kotlin
fun eval(e: Expr): Int = when(e) { 
    is Num -> 
        e.value 
    is Sum -> 
        eval3(e.left) + eval3(e.right) 
    else -> 
        throw IllegalArgumentException("Unknown expression") 
    }
```
- 복잡하면 블록도 사용 가능
```kotlin
fun evalWithLogging(e: Expr): Int =
    when(e){
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            eval(e.right) + eval(e.left)
        }
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

```
## 이터레이션
### 반복문
- while, do while
    - java와 같음
- for
    - 1..100으로 범위 설정가능
        - 끝 값까지
        - 직전까지 하고 싶으면 until 사용
    - downTo: 하행
    - step: 건너뛰기
    ```kotlin
    for (i in 1..100){
        println(i)
    }
    for (i in 100 downTo 1 step 2){
        println(i)
    }
    ```
### 맵 이터레이션
- for문을 통해 가능
```kotlin
val tree = TreeMap<Char, String>()

fun main() {
    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        tree[c] = binary
    }
    for ((letter, binary) in tree){
        println("$letter = $binary")
    }
}
```
- (letter, binary)로 키와 값 쌍 저장가능
- get, put말고 tree[c] = binary로 저장가능
- 다른 컬렉션에도 사용가능
```kotlin
val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()){
        println("$index: $element")
    }
```

