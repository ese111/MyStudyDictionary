package kotlinInAction.ch4

class LengthCount {
    var counter: Int = 0
    private set
    fun addWord(word: String) {
        counter += word.length
    }
}