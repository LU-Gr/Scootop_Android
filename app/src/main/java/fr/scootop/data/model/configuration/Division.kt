package fr.scootop.data.model.configuration

class Division {
    var id: Long? = null
    var name: String = ""
    var league: League? = null
    var category: Category? = null
    override fun toString(): String {
        return name
    }
}