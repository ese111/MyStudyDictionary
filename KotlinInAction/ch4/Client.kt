package kotlinInAction.ch4

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name &&
                postalCode == other.postalCode
    }
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
    override fun hashCode() = name.hashCode() * 31 + postalCode
    fun copy(name: String = this.name,
         postalCode: Int = this.postalCode) = Client(name, postalCode)
}
//data class Client(val name: String, val postalCode: Int)