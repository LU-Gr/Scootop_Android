package fr.scootop.data.model.request
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fr.scootop.data.definition.Footed
class RegisterUserPlayer() : Parcelable {
        @Expose
        @SerializedName("user")
        var user: RegisterUser? = null

        @Expose
        @SerializedName("taille")
        var heightCm: Int = 0

        @Expose
        @SerializedName("poids")
        var weightKg: Int = 0

        @Expose
        @SerializedName("strongFoot")
        var footed: String = Footed.Right.value

        @Expose
        @SerializedName("favoritePosition")
        var favoritePositionId: Long? = null

        @Expose
        @SerializedName("secondaryPosition")
        var secondaryPositionId: Long? = null

        @Expose
        @SerializedName("proxyTeamCountry")
        var countryCode: String? = null

        @Expose
        @SerializedName("proxyTeamCategory")
        var categoryId: Long? = null

        @Expose
        @SerializedName("proxyTeamDivision")
        var teamId: Long? = null

        constructor(parcel: Parcel) : this() {
            user = parcel.readParcelable(RegisterUser::class.java.classLoader)
            heightCm = parcel.readInt()
            weightKg = parcel.readInt()
            footed = parcel.readString().toString()
            favoritePositionId = parcel.readValue(Long::class.java.classLoader) as? Long
            secondaryPositionId = parcel.readValue(Long::class.java.classLoader) as? Long
            countryCode = parcel.readString()
            categoryId = parcel.readValue(Long::class.java.classLoader) as? Long
            teamId = parcel.readValue(Long::class.java.classLoader) as? Long
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(user, flags)
            parcel.writeInt(heightCm)
            parcel.writeInt(weightKg)
            parcel.writeString(footed)
            parcel.writeValue(favoritePositionId)
            parcel.writeValue(secondaryPositionId)
            parcel.writeString(countryCode)
            parcel.writeValue(categoryId)
            parcel.writeValue(teamId)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<RegisterUserPlayer> {
            override fun createFromParcel(parcel: Parcel): RegisterUserPlayer {
                return RegisterUserPlayer(parcel)
            }
            override fun newArray(size: Int): Array<RegisterUserPlayer?> {
                return arrayOfNulls(size)
            }
        }

        fun isValid(): Boolean {
            Log.i("register user", this.toString())
            if (heightCm > 0 &&
                weightKg > 0.0 &&
                footed != "" &&
                favoritePositionId != null &&
                countryCode != null &&
                categoryId != null &&
                teamId != null) {
                return true
            }
            return false
        }

        override fun toString(): String {
            return "Wrapper(heightCm=$heightCm, weightKg=$weightKg, footed='$footed', favoritePositionId=$favoritePositionId, countryCode=$countryCode, categoryId=$categoryId, teamId=$teamId)"
        }

        fun merge(playerWrapper: RegisterUserPlayer) {
            heightCm = playerWrapper.heightCm
            weightKg = playerWrapper.weightKg
            footed = playerWrapper.footed
            favoritePositionId = playerWrapper.favoritePositionId
            countryCode = playerWrapper.countryCode
            categoryId = playerWrapper.categoryId
            teamId = playerWrapper.teamId
        }
}