class linked{
	val header:Node? = Node()
	
	inner class Node{
	var pre: Node? = null
	var next: Node? = null
	var data: Int? = null
	}
	fun add(data: Int?){
		var end = Node()
		end.data = data
		var n:Node? = header
		while(n?.next != null){
			n = n.next!!
		}
		n?.next = end
		n?.next?.pre = header
		print()
	}
	fun delete(value: Int){
		var n = header
		while(n?.next!=null){
			if(n.next!!.data!! == value){
				n.next = n.next?.next
				n.next?.pre = n
			}else{
				n = n.next!!
			}
		}
		print()
	}
	fun insert(index: Int, data: Int?) {
		var n = header
		var insertData = Node()
		insertData.data = data
		var cnt = 0;
		while(n?.next!=null){
			if(cnt == index){
				insertData.next = n?.next
				insertData.pre = n
				n?.next = insertData
				n?.next!!.pre = insertData
			}else{
				n = n?.next
			}
			cnt++
		}
		print()
	}
	fun render() {
		var n = header
		var cnt = 0
		var sum = 0
		while(n?.next!=null){
			n = n?.next
			sum += n!!.data!!
			cnt++
		}
		println("data: $cnt 개")
		println("sum: $sum ")
	}
	fun print() {
		var n: Node? = header
		while(n?.next != null){
			print("[${n.next!!.data!!}]")
			n = n.next!!
			if(n.next != null){
				print("--->")
			}
		}
	}
}
fun start(n: linked){
	var t = true
	while(t){
		print("> ")
		var str = readLine()
		var cmd = str!!.split(" ")
		if(cmd[0] == "add"){
			n.add(cmd[1].toInt())
		}else if(cmd[0]=="render"){
			n.render()
		}else if(cmd[0] == "delete"){
			n.delete(cmd[1].toInt())
		}else if(cmd[0] == "insert"){
			n.insert(cmd[2].toInt(), cmd[1].toInt())
		}else{
			t = false
		}
		println()
	}
	
}

fun main(args: Array<String>) {
	var n = linked()
	start(n)
}