# 함수 정의, 호출
## 컬렉션 만들기
- to는 일반함수
- 코틀린은 자바 컬렉션을 이용
    - 자바와 상호작용 용이
```kotlin
val set = hashSetOf(1,7,53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
println(set.javaClass)
println(list.javaClass)
println(map.javaClass)
```
- 코틀린 기능
    - 책에 max()는 안되고 maxOrNull() 사용가능
```kotlin
val string = listOf("first", "second", "fourteenth")
    println(string.last())
    val num = setOf<Int>(1, 14, 2)
    println(num.maxOrNull())
```
## 이름 붙인 인자
- 다음 함수를 만들고 인자에 이름을 붙일때
```kotlin
fun<T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
fun main() {
    val list = listOf(1,2,3)
    println(list)
    println(joinToString(list,";","(", ")"))
}
```
- kotlin이 더 깔끔하고 쉽게 구현가능
### java 스타일
```java
println(joinToString(list, /* separator */ "",/* prefix */  "",/* postfix*/ "."))
```
### kotlin 스타일
```kotlin
println(joinToString(list, separator = "", prefix = "", postfix = "."))
```
## 디폴트 파라미터 값
- 자바는 일부 클래스에서 오버로딩 메소드가 많은 문제가 존재
    - 예) java.lang.Thread
- 디폴트 파라미터를 지정하면 과도한 오버로딩 방지 가능
```kotlin
fun<T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
)
```
- 디폴트 파라미터를 사용하면 인자가 없어도 디폴트 값을 사용가능
```kotlin
println(joinToString(list, ", "))
println(joinToString(list, postfix = "; ", prefix = "# "))
```
- @JvmOverloads 애노테이션을 사용하면 자동 오버로딩을 통해 자바에서 편하게 사용가능
## 정적 유틸리티 클래스 없애기
- 최상위 함수로 선언시 다른 패키지에서도 사용가능
- JVM 언어에서도 쉽게 호출가능
- 파일이름을 이용해서 자동으로 클래스 생성해줌
    - @file:JvmName()을 쓰면 JVM에서 쓸 클래스 이름 지정가능
```kotlin
package string

import java.lang.StringBuilder

fun<T> joinToString(
```
### 최상위 프로퍼티
- var을 이용해서 최사우이 프로퍼티 사용가능
```kotlin
var cnt = 0
```
- const val은 public static final과 같다
```kotlin
const val cnt = 3
```
## 메소드를 다른 클래스에 추가
- 확장함수는 기존 자바 API를 이용해서 코툴린의 기능을 사용가능하게 해준다
- 함수 이름 앞에 확장할 클래스 이름
    - 클래스 이름: 수신 객체 타입(String)
    - 확장 함수가 호출되는 대상이 되는 값: 수신 객체(this)
- this 생략 가능
- 확장 함수는 캡슐화를 깨지 않는다
```kotlin
package string

fun String.lastChar(): Char = this.get(this.length - 1)
```
## import와 확장함수
- import해야 함수 사용가능
```kotlin
//import string.*
import string.lastChar as last
val c = "Kotlin".last()
```
- as를 이용해서 다른이름으로 부르기도 가능
- 확장함수는 짧은 이름을 써야함
- 충돌을 막기 위해 as사용
## 자바에서 호출
- 파일이름을 사용
- 파일이름이 StringUtil.kt일때
```java
char c = StringUtillKt.lastChar("Java")
```
## 확장 함수로 유틸리티 함수 정의
- joinToString() 최종
```kotlin
fun<T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
```
- Collection에 대한 확장 함수로 선언
- 확장 함수는 단지 정적 메소드 호출에 대한 문법적인 편의일 뿐
- 클래스가 아닌 구체적인 타입을 수신 객체 타입으로 지정가능
```kotlin
fun<T> Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)
```
## 확장 함수는 오버라이드 불가
- 확장 함수는 클래스 밖에 선언되어서 오버라이드가 안된다
- 첫번쨰 인자가 수신 객체인 정적 메소드이기 때문
```kotlin
open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}
fun View.showOff() = println("i'm a view")
fun Button.showOff() = println("I'm button")
fun main() {
    val view: View = Button()
    view.click()
    view.showOff()
}
```
## 확장 프로퍼티
- 백킹 필드가 없어서 게터를 써줘야함
- 저장할 곳이 없어서 초기화 불가
- 자바에서 쓰려면 게터나 세터를 명시적으로 써줘야함
```kotlin
val String.lastChar: Char
    get() = get(length - 1)
var StringBuilder.lastChar: Char
    get() = get(this.length - 1)
    set(value: Char){
        this.setCharAt(length - 1, value)
    }
```
## 스프레드 연산자
```kotlin
fun main(args: Array<String>){
    val list = listOf("args: ", *args)
    println(list)
}
```