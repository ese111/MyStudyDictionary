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