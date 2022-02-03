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
```kotlin
package string

fun String.lastChar(): Char = this.get(this.length - 1)
```