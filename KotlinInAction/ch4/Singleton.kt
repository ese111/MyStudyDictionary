package kotlinInAction.ch4

import java.io.File
data class Person(val name: String) {
    object  NameComparator : Comparator<Person> {
        override fun compare(p0: Person, p1: Person) =
            p0.name.compareTo(p1.name)
    }
}
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees){
            //...
        }
    }
}
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(p0: File, p1: File): Int {
        return p0.path.compareTo(p1.path, ignoreCase = true)
    }
}