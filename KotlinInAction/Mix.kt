package kotlinInAction.ch02

import kotlinInAction.ch02.colors.Color.Color
import kotlinInAction.ch02.colors.Color.Color.*
import java.lang.Exception

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