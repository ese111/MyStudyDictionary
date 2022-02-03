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
- 동일한 메소드를 구현한 다른 인터페이스
```kotlin

```