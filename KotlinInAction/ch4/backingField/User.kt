package kotlinInAction.ch4.backingField

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

fun main() {
    val name = User("Alice")
    name.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}