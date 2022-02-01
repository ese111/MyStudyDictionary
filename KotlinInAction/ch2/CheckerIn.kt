package kotlinInAction.ch02

fun isLetter(c: Char) = c in 'a'..'z' || 'c' in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c:Char) = when(c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'z' -> "It's a letter!"
    else -> "i don't know"
}
fun main() {
    println(isLetter('q'))
    println(isNotDigit('3'))
    println(recognize('4'))
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java","Scala"))
}