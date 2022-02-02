fun readNumber(reader: BufferedReader){
    val number = try {
        Integer.parseInt(readLine())
    }catch (e: NumberFormatException){
        null
    }
    println(number)
}
fun main() {
    val reader = BufferedReader(StringReader("not"))
    readNumber(reader)
}