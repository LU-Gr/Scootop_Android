package fr.scootop.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Video: HydraResource() {

    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("youtube_id")
    var youtubeId: String? = null

    @Expose
    @SerializedName("views_count")
    var viewsCount = 0

    @Expose
    @SerializedName("comment")
    var comment: String? = null

    /*
    {
        "@context": "/api/contexts/Video",
        "@id": "/api/videos/26",
        "@type": "Video",
        "id": 26,
        "youtube_id": "f7FOLOLMaI4",
        "views_count": 0,
        "target_time": null,
        "comment": null,
        "player": "/api/user_players/7",
        "match": null,
        "club": null,
        "tournament": null,
        "department": null,
        "country": null,
        "date": null,
        "indexable": true
    }
    */
}
