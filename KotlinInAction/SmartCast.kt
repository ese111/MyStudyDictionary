package kotlinInAction.ch02

import java.lang.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val right: Expr, val left: Expr) : Expr

fun eval(e: Expr): Int =
    when(e){
        is Num ->
            e.value
        is Sum ->
            eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }
fun evalWithLogging(e: Expr): Int =
    when(e){
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            eval(e.right) + eval(e.left)
        }
        else ->
            throw IllegalArgumentException("Unknown expression")
    }


fun main() {
    println(eval(Sum(Sum(Num(1),Num(2)), Num(4))))
}