# 가산기
## 가산기란
가산기(adder)란 덧셈 연산을 수행하는 논리 회로이며 디지털 회로로 논리 게이트를 이용한 이진수의 덧셈을 할 수 있는 논리 회로이다.
가산기를 통하여 다른 부호의 계산도 가능해진다.

## ➕반가산기(half adder)
### 반가산기란?
![440px-Half-adder svg](https://user-images.githubusercontent.com/79190824/148626889-4621196f-392c-44c0-a73f-79a8f27b594f.png)

반가산기(half adder)는 이진수의 한자리수 두개를 받아 연산하고, 자리올림수(carry)와 합(sum)을 출력한다.  AND, OR, NOT의 세 가지 논리 게이트로 만들수 있다.

### 진리표

| A| B|	C| S|
|--|--|--|--|
| 0| 0| 0| 0|
| 0| 1| 0| 1|
| 1| 0| 0| 1|
| 1| 1| 1| 0|

## 전가산기

![440px-Full-adder svg](https://user-images.githubusercontent.com/79190824/148626888-5ebabf27-4fca-41a7-8dbd-b24d19519cbe.png)


전가산기(full adder)는 이진수 2개와 올림수 1개를 입력 받아서 계산하고 올림수와 합을 출력한다. 하나의 전가산기는 두개의 반가산기와 하나의 OR로 구성된다.
반가산기와는 다르게 올림수를 받아서 계산하기 때문에 연결해서 여러 자리의 이진수가 계산이 가능해지게 만들 수 있다.

## kotlin으로 구현한 간단한 이진수 계산기

```kotlin
//logic
fun AND(bitA: Boolean, bitB: Boolean) = if(bitA==true&&bitB==true) true else false

fun OR(bitA: Boolean, bitB: Boolean) = if(bitA==true || bitB==true) true else false

fun NOT(bit: Boolean) = !bit

fun NAND(bitA: Boolean, bitB: Boolean) = AND(NOT(bitA), NOT(bitB))

fun XOR(bitA: Boolean, bitB: Boolean) = if(bitA != bitB) true else false

fun halfAdder(bitA: Boolean, bitB: Boolean) = booleanArrayOf(AND(bitA, bitB), XOR(bitA, bitB))

fun fullAdder(bitA: Boolean, bitB: Boolean, carry: Boolean) = booleanArrayOf(OR(halfAdder(bitA, bitB)[0], halfAdder(halfAdder(bitA, bitB)[1], carry)[0]), halfAdder(halfAdder(bitA, bitB)[1], carry)[1])

fun oneByteCalculator(x: List<Boolean>, y: List<Boolean>): ArrayList<Boolean>{
	var carry: Boolean = halfAdder(x[0], y[0]).get(0)
	var ans: ArrayList<Boolean> = arrayListOf<Boolean>(halfAdder(x[0], y[0]).get(1))
	for(i in 1..x.size-1){
		ans.add(fullAdder(x[i], y[i], carry).get(1))
		carry = fullAdder(x[i], y[i], carry).get(0)
		if(i==x.size-1){
			ans.add(carry)
		}
	}
	return ans
}
//출력
fun andPrint(bitA: Boolean, bitB: Boolean) = println(AND(bitA, bitB))
fun orPrint(bitA: Boolean, bitB: Boolean) = println(OR(bitA, bitB))
fun notPrint(bit: Boolean) = println(NOT(bit))
fun nandPrint(bitA: Boolean, bitB: Boolean) = println(NAND(bitA, bitB))
fun xorPrint(bitA: Boolean, bitB: Boolean) = println(XOR(bitA, bitB))
fun halfAdderPrint(bitA: Boolean, bitB: Boolean) = println(halfAdder(bitA, bitB))
fun fullAdderPrint(bitA: Boolean, bitB: Boolean, carry: Boolean) = println(fullAdder(bitA, bitB, carry).toString())
fun oneByteCalculatorPrint(x: List<Boolean>, y: List<Boolean>) = println(oneByteCalculator(x,y).toList())
//테스트 입력받기
fun andTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	andPrint(toBoolean(x), toBoolean(y))
}
fun orTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	orPrint(toBoolean(x), toBoolean(y))
}
fun notTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	notPrint(toBoolean(x))
}
fun nandTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	nandPrint(toBoolean(x), toBoolean(y))
}
fun xorTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	xorPrint(toBoolean(x), toBoolean(y))
}
fun halfAdderTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	halfAdderPrint(toBoolean(x), toBoolean(y))
}
fun fullAdderTest() {
	println("x enter(ex: 1, 0) ")
	val x = readLine()!!
	exceptionPrint(x)
	println("y enter(ex: 1, 0) ")
	val y = readLine()!!
	exceptionPrint(y)
	println("carry enter(ex: 1, 0) ")
	val carry = readLine()!!
	exceptionPrint(carry)
	fullAdderPrint(toBoolean(x), toBoolean(y), toBoolean(carry))
}
fun oneByteCalculatorTest()	{
	println("Number enter(ex: 1100) ")
	val x = readLine()!!.chunked(1)
	arrException(x)
	println("Number enter(ex: 1100) ")
	val y = readLine()!!.chunked(1)
	arrException(y)
	oneByteCalculatorPrint(makeArr(x), makeArr(y))
}
//boolean 배열 생성
fun makeArr(x: List<String>): List<Boolean> {
	var xList = mutableListOf<Boolean>()
	for(i in x.size-1 downTo 0) {
		xList.add(toBoolean(x[i]))
	}
	return xList
}
fun toBoolean(num: String) = when(num) {
	"1" -> true
	"0" -> false
	else -> false
}
//input 예외
fun inputException(ans: String) = when(ans) {
	"1","0" -> true
	else -> false
}
fun exceptionPrint(input: String) {
	if(!inputException(input)){
		println("no!! 1 or 0!!")
		return
	} 
}
fun arrException(arr: List<String>) {
	for(i in 0..arr.size-1)
		exceptionPrint(arr[i])
}
// 테스트 메인
fun logicTest(){
	var t = true
	while(t){
		println("1. and ")
		println("2. or ")
		println("3. not ")
		println("4. nand ")
		println("5. xor ")
		println("6. halfAdder ")
		println("7. fullAdder ")
		println("8. oneByteCalculator ")
		println("9. end ")
		val sc = readLine()!!.toInt()
		if(sc == 9) t = false
		inputTest(sc)
	}
}
fun inputTest(ans: Int) =
	when(ans){
		1 -> andTest()
		2 -> orTest()
		3 -> notTest()
		4 -> nandTest()
		5 -> xorTest()
		6 -> halfAdderTest()
		7 -> fullAdderTest()
		8 -> oneByteCalculatorTest()
		9 -> println("bye~~")
		else -> println("no!!")
	}
		
fun main(args: Array<String>) {
	logicTest()
}
```

## 진리표


|A |B |X |C |S |
|--|--|--|--|--|
|0 |0 |0 |0 |0 |
|0 |0 |1 |0 |1 |
|0 |1 |0 |0 |1 |
|0 |1 |1 |1 |0 |
|1 |0 |0 |0 |1 |
|1 |0 |1 |1 |0 |
|1 |1 |0 |1 |0 |
|1 |1 |1 |1 |1 |

