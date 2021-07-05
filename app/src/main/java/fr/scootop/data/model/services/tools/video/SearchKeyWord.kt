package fr.scootop.data.model.services.tools.video

import android.os.Parcel
import android.os.Parcelable

class SearchKeyWord(): Parcelable {
    var id: Long? = null
    var name: String? = null
    var videos: List<Video>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        name = parcel.readString()
        videos = parcel.createTypedArrayList(Video)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeTypedList(videos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchKeyWord> {
        override fun createFromParcel(parcel: Parcel): SearchKeyWord {
            return SearchKeyWord(parcel)
        }

        override fun newArray(size: Int): Array<SearchKeyWord?> {
            return arrayOfNulls(size)
        }
    }
}