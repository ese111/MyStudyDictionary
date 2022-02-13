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
- 생성자도 디폴트 값 사용 가능
```kotlin
class User (val nickname: String, val isSubscried: Boolean = true)
```
- 호출시에는 new없이 호출
```kotlin
val park = User("peter")
```
- 기반 클래스를 초기화하려면 기반 클래스 이름 뒤에 괄호를 치고 생성자 인자를 넘김
```kotlin
open class User (val nickname: String) 
class TwitterUser(nickname: String): User(nickname) {
    
} 
```
- 생성자가 없으면 자동으로 인자가 없는 디폴트 생성자를 만듬 그래서 호출시 생성자를 호출해야함
```kotlin
open class Switch
class RadioButton: Switch()
```
- 인터페이스는 생성자가 없어서 ()가 없음
- 클래스 외부에서 인스턴스화하지 못하게 하려면 private을 붙이면됨
    - 그 클래스 안에는 주 생성자밖에 없고 그 주 생성자는 비공개이므로 외부에서 인스턴스 불가
```kotlin
class Secretive private constructor() {}
```
## 부 생성자
- 부 생성자 만드는 법
```kotlin
open class View {
    constructor(ctx: Context) {
        println("context!")
    }

    constructor(ctx: Context, attr: AttributeSet) {
        println("attributeSet!!")
    }
}
```
- 확장 가능
```kotlin
class MyButton : View {
    constructor(ctx: Context)
            : super(ctx) {

    }

    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr) {

    }
}
```
- this로 위임 가능
    - 주 생성자가 없다면 자신의 다른 생성자를 초기화해서 불러줘야함
```kotlin
class MyButton : View {
    constructor(ctx: Context) : this(ctx, null){
        // ...
    }
    constructor(ctx: Context, attr: AttributeSet?) : super(ctx, attr){
        // ...
    }
}
```
## 프로퍼티 구현
- 서로 다른 구현을 하는 3개의 클래스
```kotlin
interface User{
    val name: String
}
class PrivateUser(override val name: String) : User
class SubscribingUser(val email: String): User {
    override val name: String
        get() = email.substringBefore('@')
}
class FaceBookUser(val accountId: Int):User{
    override val name = getFaceBookId(accountId)
}
```
- PrivateUser: 주 생성자에 프로퍼티 선언
- SubscribingUser: 커스텀 게터 사용
- FaceBookUser: getFaceBookId()라는 함수가 있다는 가정하에 작성
- SubscribingUser와 FaceBookUser는 다르다
    - 인터페이스는 백킹 필드가 없어서 상태를 저장 할 수 없어서 커스텀 게터를 사용한 SubscribingUser는 매번 정보를 불러오는 구조이고 상태를 저장해서 불러오는 FaceBookUser는 한 번만 함수를 써서 초기화한다

## 게터와 세터에서 백킹필드 접근
```kotlin
class User(val name: String) {
    var address: String = "unspecified"
    set(value: String) {
        println("""
            Address was changed for $name:
            "$field" -> "$value".
        """.trimIndent())
        field = value
    }
}
```
- val는 게터만 var 세터, 게터 필드 필요
- field라는 식별자를 이용해서 값을 저장하고 불러올 수 있음
- field를 쓰면 자동을 백킹 필드를 만들어줌
- field가 없는 커스텀 접근자는 백킹 필드도 없음

## 접근자의 가시성 변경
- 접근자도 가시성을 변경할 수 있다
```kotlin
class LengthCount {
    var counter: Int = 0
    private set
    fun addWord(word: String) {
        counter += word.length
    }
}
```
- 게터는 자동으로 생성하고 변경은 내부에서만 하게 하고 싶을때
- counter를 외부에서 변경할 수 없게 세터에 private을 설정
## 모든 클래스가 정의해야 하는 메소드
- toString, equals, hashCode 등을 오버라이드해서 사용 가능
- Client 클래스에 구현해보기
```kotlin
class Client(val name: String, val postalCode: Int) {
```
- ### toString
```kotlin
class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
}
```
- ### equals
    - 만약 같은 값을 가진 객체면 동일한 객체라고 인식해야할 경우
- 코틀린은 ==를 사용하면 내부에서 equals를 불러서 실행함
- 두 객체의 값이 같으면 true
- 오버라이드된 함수인자의 Any?를 Client로 변경이 불가해서 !is로 객체 타입을 검사
```kotlin
class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name && 
                postalCode == other.postalCode
    }
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
}
```

- ### hashCode()
- hashSet을 사용하면 HashSet은 hashCode를 이용해서 객체가 존재하는지를 체크함 하지만 위 equals는 hashCode가 없어서 set을 쓰면 중복 값이 저장이 된다 고로 hashCode를 만들어야함
```kotlin
override fun hashCode() = name.hashCode() * 31 + postalCode
```
## 데이터 클래스
- 위의 코드를 코틀린은 작성하지 않아도 자동으로 해줌
- data class는 생성자밖에 프로퍼티들은 고려하지 않음
```kotlin
data class Client(val name: String, val postalCode: Int) 
```
- data class : copy()
- copy()는 데이터 클래스를 불변상태로 사용 활용하는데 도움을 줌
- data class의 프로퍼티가 val일 필요는 없지만 불변상태를 권장
- 불변상태 장점
    - HashMap 등의 컨테이너에 담아야한다면 필수적으로 불변 상태여야함
        - 키로 쓰인 프로퍼티가 변경되면 컨테이너 상태가 잘못될 수 있음
    - 다중 스레드를 사용할떄는 더 중요
        - 다른 스레드가 사용중인 데이터를 변경할 수 없음
        - 동기화 안해도됨
- 객체를 복사하면서 값을 바꾸거나 복사본을 제거해도 원본에는 손상이 없음
- 구현
```kotlin
class Client(val name: String, val postalCode: Int) {
    fun copy(name: String = this.name,
         postalCode: Int = this.postalCode) = Client(name, postalCode)
}
```
- 사용법
```
val lee = Client("lee", 4122)
println(lee.copy(postalCode = 4000))
```
## 위임
- 코틀린은 과도한 상속에 대한 문제점과 상위 클래스가 변경 될때 일어나는 하위 클래스의 문제를 인식하고 기본을 final로 하고 상속을 막음
- 상속을 허용하지 않은 클래스에 새로운 동작을 추가해야 할 때 일반적인 방법이 데코레이터 패턴
    - 데코레이터 패턴이란
        - 상속을 허용하지 않는 클래스 대신 사용할 수 있는 새로운 클래스를 만등되 기존 클래스와 같은 인터페이스를 데코레이터가 제공하게 만들고, 기존 클래스를 데코레이터 내부에 필드로 유지하는 것
    - 단점
        - 준비가 많이 필요
        - 동작이 필요없는 데코레이터
        ```kotlin
        class DelegatingCollection<T>: Collection<T> {
            private val innerList = arrayListOf<T>()
            override val size: Int get() = innerList.size
            override fun isEmpty(): Boolean = innerList.isEmpty()
            override fun contains(element: T): Boolean = innerList.contains(element)
            override fun iterator(): Iterator<T> = innerList.iterator()
            override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)    
        }
        ``` 
        - 위임으로 변경
        ```kotlin
        class DelegatingCollection<T>(innerList:Collection<T> = ArrayList<T>()): Collection<T> by innerList
        ```
- 위임으로 원소 추가 횟수를 기록하는 컬렉션 만들기
```kotlin
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()): MutableCollection<T> by innerSet{
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded++
        return innerSet.addAll(elements)
        }
    }
```
- CountingSet 은 MutableCollection의 구현 방식에 의존관계가 없다
## 객체 선언: 싱글턴 패턴
- kotlin은 object를 사용해서 편하게 싱글턴을 구현가능
- 객체 선언에서 생성자는 사용 불가(실글턴 객체는 선언문이 있는 곳에서 바로 만들어짐)
```kotlin
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees){
            //...
        }
    }
}
```
- 객체 선언도 클래스나 인터페이스를 상속가능
    - comparator 은 데이터를 저장할 필요가 없고 클래스마다 하나면 충분해서 객체 선언에 적당
```kotlin
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(p0: File, p1: File): Int {
        return p0.path.compareTo(p1.path, ignoreCase = true)
    }
}
```
- 대형 프로젝트에서는 객체 생성을 제어할 수 없고 파라미터도 없는 싱글턴과 객체 선언이 항상 좋지는 않음
- 중첩 객체로 Comparator 구현
```kotlin
data class Person(val name: String) {
    object  NameComparator : Comparator<Person> {
        override fun compare(p0: Person, p1: Person) =
            p0.name.compareTo(p1.name)
    }
}
```
- 객체 자바에서 쓰기
    - 자바에서 코틀린 객체 선언은 유일한 인스턴스에 대한 정적 필드가 있는 자바 클래스로 컴파일됨
    - 인스턴스 필드의 이름은 항상 INSTANCE 
```java
CaseInsensitiveFileComparator.INSTANCE.compare(file1, file2);
```
- 싱글턴과 의존관계 주입
    - 싱글턴 패턴과 마찬가지고 객체 선언은 대규모에는 맞지 않다
    - 객체 생성을 제어할 수 없기 때문
    - 생성자 파라미터를 지정할 수 없음
    - 의존관계 주입 프레임워크와 쓰는게 좋다
## 동반 객체: 팩토리 메소드와 정적 멤버
- 코틀린 static이 없다
    - 대신 패키지 수준의 최상위 함수와 객체 선언이 있다
    - 최상위 함수는 private으로 표시된 클래스 비공개 멤버에 접근 불가
- 클래스 내부 정보에 접근해야할때
    - 중첩된 객체 선언의 멤버 함수로 정의해야함(예: 팩토리 메서드)
```kotlin
    class Companion {
        companion object{
            fun bar() {
                println("Companion object called")
            }
        }
    }

    fun main() {
        Companion.bar()
    }
```
- 팩토리 메서드 예시
- 부생성자가 여럿있는 클래스 팩토리 메서드로 바꾸기
- before
```kotlin
class User{
    val name: String
    constructor(email: String){
        name = email.substringBefore('@')
    }
    constructor(facebookAccountId: Int){
        name = kotlinInAction.ch4.getFaceBookId(facebookAccountId)
    }
}
```
- after
```kotlin
fun getFaceBookId(accountId: Int) = "Mark Zuckerberg"

class User private constructor(val nickname: String) {
    companion object{
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) =
            User(getFaceBookId(accountId))
    }
}

fun main() {
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}
```
## 동반 객체를 일반 객체처럼 사용
- 동반 객체는 클래스 안에 정의된 일반 객체
- 이름 붙이기 가능
- 인터페이스 상속 가능
- 확장 함수와 프로퍼티 정의 가능
```kotlin
class Person(val name: String) { companion object Loader { // 동반 객체에 이름을 붙인다. 
    fun fromJSON(jsonText: String) : Person = ... } 
} 
>>> person = Person.Loader.fromJSON("{name: 'Dmitry'}") // 두 방법 모두 제대로 fromJSON을 호출할 수 있다. 
>>> person.name Dmitry 
>>> person2 = Person.fromJSON("{name: 'Brent'}") 
>>> person2.name Brent
```



