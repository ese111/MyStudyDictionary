package com.example.kotlininaction

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()}:${Thread.currentThread()}:${msg}")

fun runBlockingExample(){
    runBlocking {
        GlobalScope.launch {
            delay(1000L)
            log("World!")
        }
        log("Hello,")
        delay(2000L)
    }
}

fun yieldExample(){
    runBlocking {
        launch {
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }
        log("after first launch")
        launch {
            log("2")
            delay(1000L)
            log("4")
            delay(1000L)
            log("6")
        }
        log("after second runBlocking")
    }
    log("after runBlocking")
}
fun sumAll(){
    runBlocking {
        val d1 = async { delay(1000L); 1 }
        log("after async(d1)")
        val d2 = async { delay(2000L); 2 }
        log("after async(d2)")
        val d3 = async { delay(3000L); 3 }
        log("after async(d3)")
        log("1+2+3=${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}
fun main(args: Array<String>) {
   log("main() started.")
   yieldExample()
   log("yieldExample() executed")
   Thread.sleep(5000L)
   log("main terminated")
    runBlockingExample()
    sumAll()
}

