package fr.scootop.data.model.configuration

import android.os.Parcel
import android.os.Parcelable

class Category(): Parcelable {
    val id: Long? = null
    val name: String = ""
    val categoryType: CategoryType? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun toString(): String {
        return name
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}