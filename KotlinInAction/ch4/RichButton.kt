package kotlinInAction.ch4

open class RichButton: Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {
    }
    fun animateTwice() {
    }
}

open class User (val nickname: String)
class TwitterUser(nickname: String): User(nickname) {

}
open class Switch
class RadioButton: Switch()