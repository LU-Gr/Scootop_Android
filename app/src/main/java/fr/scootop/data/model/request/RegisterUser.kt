package fr.scootop.data.model.request
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterUser() : Parcelable {

    @Expose
    @SerializedName("firstName")
    var firstName: String? = null

    @Expose
    @SerializedName("lastName")
    var lastName: String? = null

    @Expose
    @SerializedName("email")
    var email: String? = null

    @Expose
    var password: String? = null

    @Expose
    @SerializedName("birthDate")
    var birthDate: String? = null

    @Expose
    @SerializedName("gender")
    var gender: String? = "M"

    @Expose
    @SerializedName("nationalityCountry")
    var nationalityCountry: String? = null

    @Expose
    @SerializedName("originCountry")
    var originCountry: String? = null

    @Expose
    @SerializedName("phoneNumber")
    var phoneNumber: String? = null

    constructor(parcel: Parcel) : this() {
        firstName = parcel.readString()
        lastName = parcel.readString()
        email = parcel.readString()
        password = parcel.readString()
        birthDate = parcel.readString()
        gender = parcel.readString()
        nationalityCountry = parcel.readString()
        originCountry = parcel.readString()
        phoneNumber = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(birthDate)
        parcel.writeString(gender)
        parcel.writeString(nationalityCountry)
        parcel.writeString(originCountry)
        parcel.writeString(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterUser> {
        override fun createFromParcel(parcel: Parcel): RegisterUser {
            return RegisterUser(parcel)
        }
        override fun newArray(size: Int): Array<RegisterUser?> {
            return arrayOfNulls(size)
        }
    }

    fun isValid(): Boolean {
        if (firstName != null &&
            lastName != null &&
            email != null &&
            password != null &&
            birthDate != null &&
            gender != null &&
            nationalityCountry != null &&
            originCountry != null &&
            phoneNumber != null) {
            return true
        }
        return false
    }
}
