package fr.scootop.data.model.request
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class RegisterUserObserver {
    @Expose
    @SerializedName("observer")
    private var observerWrapper: Wrapper = Wrapper()
    fun setUser(user: RegisterUser) {
        observerWrapper.setUser(user)
    }
    internal inner class Wrapper {
        @Expose
        @SerializedName("user")
        private var user: RegisterUser? = null
        fun setUser(user: RegisterUser) {
            this.user = user
        }
    }
}
