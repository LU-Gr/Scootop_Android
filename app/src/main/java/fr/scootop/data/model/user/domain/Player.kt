package fr.scootop.data.model.user.domain

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.Category
import fr.scootop.data.model.configuration.Poste
import fr.scootop.data.model.services.tools.video.Video
import fr.scootop.data.model.tools.StatisticalSheet
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.User

class Player(): Parcelable {
    var id: Long? = null
    var rating: Int = 0
    var taille: Int = 0
    var poids: Int = 0
    var vma: Int = 0
    var description: String? = null
    var nationalite: String? = null
    var origin: String? = null
    var isSelected: Boolean = false
    var isSubstitute: Boolean = false
    var interaction: Int = 0
    var strongFoot: String? = null
    var weekFoot: String? = null
    var photoUrl: String? = null
    var user: User? = null
    var category: Category? = null
    var statisticalSheets: List<StatisticalSheet>? = null
    var videos: List<Video>? = null
    var teams: List<Team>? = null
    var postes: List<Poste>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        rating = parcel.readInt()
        taille = parcel.readInt()
        poids = parcel.readInt()
        vma = parcel.readInt()
        nationalite = parcel.readString()
        description = parcel.readString()
        origin = parcel.readString()
        isSelected = parcel.readByte() != 0.toByte()
        isSubstitute = parcel.readByte() != 0.toByte()
        interaction = parcel.readInt()
        strongFoot = parcel.readString()
        weekFoot = parcel.readString()
        photoUrl = parcel.readString()
        user = parcel.readParcelable(User::class.java.classLoader)
        category = parcel.readParcelable(Category::class.java.classLoader)
        statisticalSheets = parcel.createTypedArrayList(StatisticalSheet.CREATOR)
        videos = parcel.createTypedArrayList(Video.CREATOR)
        teams = parcel.createTypedArrayList(Team)
        postes = parcel.createTypedArrayList(Poste)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(rating)
        parcel.writeInt(taille)
        parcel.writeInt(poids)
        parcel.writeString(description)
        parcel.writeInt(vma)
        parcel.writeString(nationalite)
        parcel.writeString(origin)
        parcel.writeByte(if (isSelected) 1 else 0)
        parcel.writeByte(if (isSubstitute) 1 else 0)
        parcel.writeInt(interaction)
        parcel.writeString(strongFoot)
        parcel.writeString(weekFoot)
        parcel.writeString(photoUrl)
        parcel.writeParcelable(user, flags)
        parcel.writeParcelable(category, flags)
        parcel.writeTypedList(statisticalSheets)
        parcel.writeTypedList(videos)
        parcel.writeTypedList(teams)
        parcel.writeTypedList(postes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}

