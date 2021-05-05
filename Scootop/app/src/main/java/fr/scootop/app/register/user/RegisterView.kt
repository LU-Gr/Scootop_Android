package fr.scootop.app.register.user

interface RegisterView {
    
    fun showLoading()

    fun hideLoading()

    fun displayError(message: String)

    fun displayHome()
}
