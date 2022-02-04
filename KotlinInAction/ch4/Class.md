# 클래스, 객체, 인터페이스
## 인터페이스
```kotlin
interface Clickable{
    fun click()
}
class Button : Clickable {
    override fun click() = println("I was clicked")
}
```
- 코틀린은 interface로 인터페이스를 선언
- extends, implements를 쓰지 않고 :로 구현
- @Override = override 변경자를 함수 앞에 붙임
- 인터페이스도 디폴트 구현을 제공
```kotlin
interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable!")
}
```
- 이 인터페이스를 구현하는 클래스는 click에 대한 구현을 제공해야한다
- showOff()는 새로운 동작을 구현해도 되고 디폴트를 써도 됨
- 동일한 메소드를 구현한 다른 인터페이스를 함께 구현할때
    - Class 'Button' must override public open fun showOff(): Unit defined in kotlinInAction.ch4.Clickable because it inherits multiple interface methods of it 오류 발생
    - 하위 클래스에서 직접 메소드를 구현해야한다
```kotlin
class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
```
- 하나만 사용할 경우는 이런식으로 구현가능
```kotlin
fun main() {
    val f = Button()
    f.showOff()
}
```
## open, final, abstract 변경자
- 취약 기반 클래스
    - 기반 클래스에 대해 가졌던 가정이 기반 클래스가 변경함으로써 깨지는 경우
    - 코틀린은 조슈아 블로크의 상속금지 철학을 따라 final을 기본으로 잡는다
- open을 쓰면 상속 가능
- 기본은 final
- final을 붙이면 상속 금지(override된 메소드는 기본적으로 열려있어서 닫아 줘야한다)
```kotlin
open class RichButton: Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {}
}
```
- 추상 멤버는 항상 열려있다
- 추상 클래스여도 비추상함수는 기본 final이지만 open사용가능
```kotlin
abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {
    }
    fun animateTwice() {
    }
}
```
|변경자|오버라이드 가능여부|설명|
|--|--|--|
|final| 불가 | 기본 변경자|
|open| 가능 | open 명시하면 오버라이드 가능|
|abstract|반드시 오버라이드|추상 클래스 멤버만 사용가능 구현이 있으면 안됨|
|override|상위 클래스나 상위 인스턴스의 멤버 오버라이드 중|오버라이드를 금지하려면 final명시|
## 가시성 변경자
|변경자|클래스 멤버|최상위 선언|
|--|--|--|
|public(기본)|모든 곳| 모든 곳|
|internal|같은 모듈|같은 모듈|
|protected|하위 클래스|최상위에는 적용 불가|
|private|같은 클래스|캍은 파일|

- 확장함수는 protected, private에 접근 불가

## 내부 클래스와 중첩 클래스
- 코틀린의 중첩 클래스는 명시적으로 요청하지 않는 한 바깥쪽 클래스 인스턴스에 대한 접근 권한이 없다
예시 View 직렬화하기
- 직렬화란
    - 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술
    - JVM의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술
- 이유
    - 객체를 파일화 하거나 객체를 주고 받거나 저장해야 할떄 사용
```kotlin
interface State: Serializable

interface View{
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}
```
- java
```java
public class Button implements View {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }
    @Override
    public void restoreState(State state) {}
    public class ButtonState implements State {}
}
```
- 이렇게 자바로 코드를 짜게되면 직렬화를 할 수 없다는 오류가 발생
- 자바는 다른 클래스 안에 있는 클래스를 자동을 내부 클래스로 인식
- ButtonState는 묵시적으로 Button을 참조하게 되고 Button은 직렬화가 불가능하기 때문에 직렬화가 안되는 오류가 발생
- 해결
    - ButtonState를 static으로 변경한다.
- Kotlin
```kotlin
class Button1: View{
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState: State {}
}
```
- 코틀린은 내부 클래스로 인식하려면 inner를 붙여줘야됨
- 코틀린의 중첩 클래스는 변경자가 없으면 static과 같음
- 내부에서 외부를 참조하려면 this@Outer를 써줘야함
```kotlin
class Outer{
    inner class Inner{
        fun getOuterReference() : Outer = this@Outer
    }
}
```
## 봉인된 클래스
- sealed는 클래스 외부에 상속 클래스는 둘 수 없음
- sealed 변경자를 사용하면 상위 클래스를 상속한 하위 클래스 정의를 제한 할 수 있음
- sealed를 사용할 때에는 반드시 하위 클래스가 중첩 클래스여야함
- when에서 sealed의 모든 하위 클래스를 처리하면 else가 없어도됨
- sealed는 자동 open
```kotlin
sealed class Expr{
    class Num(val value: Int) : Expr()
    class Sum(val right: Expr, val left: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when(e){
        is Expr.Num ->
            e.value
        is Expr.Sum ->
            eval(e.right) + eval(e.left)
    }
```
- sealed로 처리하면 나중에 상속 계층에 새로운 하위 클래스가 추가될때 when에도 추가 해야함을 알 수 있음
- sealed는 자바에서 구현하는 걸 막을 수 없기 때문에 내부적으로 private으로 되어있음

## class 초기화 
- 주생성자
```kotlin
class User(val nickname: String)
```
- 주생성자의 내부
```kotlin
class User constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}
```
- constructor
    - 주생성자나 부생성자를 정의
- init
    - 초기화 블록
    - 주 생성자와 함께 사용
    - 주 생성자는 제한적이기 때문에 초기화 블록 필요
- 간단하게 변경
```kotlin
class User (_nickname: String) {
    val nickname = _nickname
}
```
- _는 구분을 위한 사용(자바처럼 this.nickname = nickname도 가능)
- 주 생성자 앞에 애노테이션이나 가시성 변경자가 없다면 constructor 생략 가능
