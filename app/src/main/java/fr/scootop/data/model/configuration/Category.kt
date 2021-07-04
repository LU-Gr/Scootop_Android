package fr.scootop.data.model.configuration

class Category {
    val id: Long? = null
    val name: String = ""
    val categoryType: CategoryType? = null
    override fun toString(): String {
        return name
    }
}