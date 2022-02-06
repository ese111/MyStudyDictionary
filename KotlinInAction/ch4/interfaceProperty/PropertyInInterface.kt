package kotlinInAction.ch4.interfaceProperty

interface User{
    val name: String
}
class PrivateUser(override val name: String) : User
class SubscribingUser(val email: String): User {
    override val name: String
        get() = email.substringBefore('@')
}
class FaceBookUser(val accountId: Int):User{
    override val name = getFaceBookId(accountId)
}
fun getFaceBookId(accountId: Int) = "Mark Zuckerberg"