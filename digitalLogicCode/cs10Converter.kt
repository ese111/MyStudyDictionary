//10 -> 2
fun dec2bin(dec: Int): MutableList<Boolean> {
	var bin: MutableList<Int> = mutableListOf()
	var num = dec
	while(num!=0) {
		bin.add(num%2)
		num = num/2
		println(num)
	}
	return boolMake(bin)
}
fun boolMake(bin: MutableList<Int>): MutableList<Boolean> {
	var bool: MutableList<Boolean> = mutableListOf()
	for(i in 0..bin.size-1) {
		if(bin[i] == 1) {
			bool.add(true)
		}else{
			bool.add(false)
		}
	}
	return bool
}
fun dec2binPrint(dec: Int) = println("in : ${dec} \n ${dec2bin(dec).toMutableList()}")

// 2 -> 10
fun bin2dec(bin: BooleanArray ): Int {
	var dec: Int = 0
	var binarySquared: MutableList<Int> = binarySquaredList(bin.size-1)
	for(i in 0..bin.size-1) {
		when(bin[i]) {
			true -> dec += binarySquared[i]
		}
	}
	return dec
}

fun binarySquaredList(binSize: Int): MutableList<Int>{
	var binarySquared: MutableList<Int> = mutableListOf()
	var num = 1
	binarySquared.add(num)
	for(i in 1..binSize) {
		binarySquared.add(num*2)
		num *= 2
	}
	println(binarySquared.toList())
	return binarySquared
}
fun bin2decPrint(bin: BooleanArray) = println("in:  ${bin.toList()} \n out:  ${bin2dec(bin)}")


fun main(args: Array<String>) {
	dec2binPrint(10)
	dec2binPrint(173)
	bin2decPrint(booleanArrayOf(false, true, true, true))
	bin2decPrint(booleanArrayOf(true, true, true, true, false, true, false, true))
}

	