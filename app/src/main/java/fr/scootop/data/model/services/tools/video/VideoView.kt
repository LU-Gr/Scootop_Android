package fr.scootop.data.model.services.tools.video

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.user.User
import java.time.LocalDate

class VideoView(): Parcelable {
    var id: Long? = null
    var date: LocalDate? = null
    var video: Video? = null
    var user: User? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        video = parcel.readParcelable(Video::class.java.classLoader)
        user = parcel.readParcelable(User::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeParcelable(video, flags)
        parcel.writeParcelable(user, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VideoView> {
        override fun createFromParcel(parcel: Parcel): VideoView {
            return VideoView(parcel)
        }

        override fun newArray(size: Int): Array<VideoView?> {
            return arrayOfNulls(size)
        }
    }
}