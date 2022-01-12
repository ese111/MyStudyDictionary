class Queue<T>{
    class Node<T>(val data: T){
        var next: Node<T>? = null
    }
    var first: Node<T>? = null
    var last: Node<T>? = null
    fun add(data: T) {
        var item = Node<T>(data)
        if(last != null){
            last!!.next = item
        }
        last = item
        if(first == null){
            first = last
        }
    }
    fun remove(): T? {
        if(first == null){
            throw NoSuchElementException("Nothing!")
        }
        val data: T = first!!.data
        first = first?.next
        if(first==null){
            last = null
        }
        return data
    }
    fun peek(): T? {
        if(first == null){
            throw NoSuchElementException("Nothing!")
        }
        return first!!.data
    }
    fun isEmpty(): Boolean = if(first == null) true else false

}
fun main(args: Array<String>) {
    var z = Queue<Int>()
    z.add(1)
    z.add(2)
    z.add(3)
    z.add(4)
    z.add(5)
    z.add(6)
    println(z.isEmpty())
    println(z.remove())
    println(z.peek())
    println(z.remove())
    println(z.remove())
    println(z.remove())
    println(z.remove())
    println(z.remove())
    println(z.isEmpty())
    println(z.remove())
}

