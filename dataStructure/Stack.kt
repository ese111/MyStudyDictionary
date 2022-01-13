
class Stack<T>{
    class Node<T>(val data: T){
        var pre: Node<T>? = null
    }
    var last: Node<T>? = null

    fun push(data: T) {
        var item = Node<T>(data)
        if(last!=null){
            item.pre = last
        }
        last = item
    }
    fun pop(): T {
        if(last==null){
            throw NoSuchElementException("Nothing!")
        }
        var data: T = last!!.data
        last = last?.pre
        return data
    }
    fun peek(): T{
        if(last==null){
            throw NoSuchElementException("Nothing!")
        }
        return last!!.data
    }
    fun isEmpty(): Boolean = if(last==null) true else false
}

fun main(args:Array<String>) {
    var s = Stack<Int>()
    s.push(1)
    s.push(2)
    s.push(3)
    println(s.isEmpty())
    println(s.peek())
    println(s.pop())
    println(s.peek())
    println(s.pop())
    println(s.pop())
    println(s.isEmpty())
}