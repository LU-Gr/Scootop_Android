package fr.scootop.data.model.request

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fr.scootop.data.definition.Footed

class RegisterUserPlayer {

    @Expose
    @SerializedName("player")
    var wrapper: Wrapper = Wrapper()

    class Wrapper() : Parcelable {

        @Expose
        @SerializedName("user")
        var user: RegisterUser? = null

        @Expose
        @SerializedName("heightCm")
        var heightCm: Int = 0

        @Expose
        @SerializedName("weightKg")
        var weightKg: Double = 0.0

        @Expose
        @SerializedName("footed")
        var footed: String = Footed.Right.value

        @Expose
        @SerializedName("favoritePosition")
        var favoritePositionId: Int? = null

        @Expose
        @SerializedName("secondaryPosition")
        var secondaryPositionId: Int? = null

        @Expose
        @SerializedName("proxyTeamCountry")
        var countryCode: String? = null

        @Expose
        @SerializedName("proxyTeamCategory")
        var categoryId: Int? = null

        @Expose
        @SerializedName("proxyTeamDivision")
        var divisionId: Int? = null

        @Expose
        @SerializedName("proxyClubName")
        var clubName: String? = null

        constructor(parcel: Parcel) : this() {
            user = parcel.readParcelable(RegisterUser::class.java.classLoader)
            heightCm = parcel.readInt()
            weightKg = parcel.readDouble()
            footed = parcel.readString().toString()
            favoritePositionId = parcel.readValue(Int::class.java.classLoader) as? Int
            secondaryPositionId = parcel.readValue(Int::class.java.classLoader) as? Int
            countryCode = parcel.readString()
            categoryId = parcel.readValue(Int::class.java.classLoader) as? Int
            divisionId = parcel.readValue(Int::class.java.classLoader) as? Int
            clubName = parcel.readString()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(user, flags)
            parcel.writeInt(heightCm)
            parcel.writeDouble(weightKg)
            parcel.writeString(footed)
            parcel.writeValue(favoritePositionId)
            parcel.writeValue(secondaryPositionId)
            parcel.writeString(countryCode)
            parcel.writeValue(categoryId)
            parcel.writeValue(divisionId)
            parcel.writeString(clubName)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Wrapper> {
            override fun createFromParcel(parcel: Parcel): Wrapper {
                return Wrapper(parcel)
            }

            override fun newArray(size: Int): Array<Wrapper?> {
                return arrayOfNulls(size)
            }
        }

        fun isValid(): Boolean {
            if (heightCm > 0 &&
                weightKg > 0.0 &&
                footed != "" &&
                favoritePositionId != null &&
                countryCode != null &&
                categoryId != null &&
                divisionId != null &&
                clubName != null) {
                return true
            }
            return false
        }
    }

    fun merge(playerWrapper: RegisterUserPlayer.Wrapper) {
        wrapper.heightCm = playerWrapper.heightCm
        wrapper.weightKg = playerWrapper.weightKg
        wrapper.footed = playerWrapper.footed
        wrapper.favoritePositionId = playerWrapper.favoritePositionId
        wrapper.countryCode = playerWrapper.countryCode
        wrapper.categoryId = playerWrapper.categoryId
        wrapper.divisionId = playerWrapper.divisionId
        wrapper.clubName = playerWrapper.clubName
    }
}