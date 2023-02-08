package com.farmapp.customerapp.models

import android.os.Parcel
import android.os.Parcelable

class NotificationModel (val notification: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(notification)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NotificationModel> {
        override fun createFromParcel(parcel: Parcel): NotificationModel {
            return NotificationModel(parcel)
        }

        override fun newArray(size: Int): Array<NotificationModel?> {
            return arrayOfNulls(size)
        }
    }
}




data class Notificationlist(val name: String?, val price: Float,  val url: String?, var totalInCart: Int) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(price)
        parcel.writeString(url)
        parcel.writeInt(totalInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Notificationlist> {
        override fun createFromParcel(parcel: Parcel): Notificationlist {
            return Notificationlist(parcel)
        }

        override fun newArray(size: Int): Array<Notificationlist?> {
            return arrayOfNulls(size)
        }
    }
}