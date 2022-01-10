class Video(var name: String , var id: String, var time: Int, var next: Video?){
	fun print(){
		println("$name ( $id ) : $time")
	}
}
fun videosMk(){
	var videoList = ArrayList<Video>()
	val n = 13
	for(i in 1..n){
		val name = "제목".plus(i)
		val time  = (1..15).random()
		val id = idMk(i, time)
		val video = Video(name, id, time, null)
		videoList.add(video)
	}
	print(videoList)
}
fun idMk(n:Int, time: Int): String{
	val k = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'n',
		'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
	val x = (0..25).random()
	val y = (0..12).random()+(0..13).random()
	val z = time + (0..10).random()
	return k[x].toString() + k[n]+ k[y] + k[z]
}
fun print(n: ArrayList<Video>) {
	println("---영상클립---")
	for(i in n){
		println(i.print())
	}
}
fun main(args: Array<String>){
	videosMk()
}