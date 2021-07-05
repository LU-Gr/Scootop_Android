package fr.scootop.data.model.services.tools.video

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.CompetitionType
import fr.scootop.data.model.services.Event
import fr.scootop.data.model.user.domain.Player
import java.util.*

class Video(): Parcelable {
    var id: Long? = null
    var player: Player? = null
    var url: String? = null
    var posted: Date? = null
    var event: Event? = null
    var competitionType: CompetitionType? = null
    var views: List<VideoView>? = null
    var keywords: List<SearchKeyWord>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        player = parcel.readParcelable(Player::class.java.classLoader)
        url = parcel.readString()
        event = parcel.readParcelable(Event::class.java.classLoader)
        competitionType = parcel.readParcelable(CompetitionType::class.java.classLoader)
        views = parcel.createTypedArrayList(VideoView.CREATOR)
        keywords = parcel.createTypedArrayList(SearchKeyWord.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeParcelable(player, flags)
        parcel.writeString(url)
        parcel.writeParcelable(event, flags)
        parcel.writeParcelable(competitionType, flags)
        parcel.writeTypedList(views)
        parcel.writeTypedList(keywords)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Video> {
        override fun createFromParcel(parcel: Parcel): Video {
            return Video(parcel)
        }

        override fun newArray(size: Int): Array<Video?> {
            return arrayOfNulls(size)
        }
    }
}