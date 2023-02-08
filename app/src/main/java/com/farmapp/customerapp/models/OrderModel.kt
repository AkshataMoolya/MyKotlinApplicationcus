package com.farmapp.customerapp.models

import android.os.Parcel
import android.os.Parcelable

class OrderModel (val orderid: String?,
                  val totalbill: String?,val status: String?,
                  val date: String?, var orderlist: List<Orderlist?>?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Orderlist)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(orderid)
        parcel.writeString(totalbill)
        parcel.writeString(status)
        parcel.writeString(date)
        parcel.writeTypedList(orderlist)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrderModel> {
        override fun createFromParcel(parcel: Parcel): OrderModel {
            return OrderModel(parcel)
        }

        override fun newArray(size: Int): Array<OrderModel?> {
            return arrayOfNulls(size)
        }
    }
}




data class Orderlist(val name: String?, val price: Float,  val url: String?, var totalInCart: Int) :
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

    companion object CREATOR : Parcelable.Creator<Orderlist> {
        override fun createFromParcel(parcel: Parcel): Orderlist {
            return Orderlist(parcel)
        }

        override fun newArray(size: Int): Array<Orderlist?> {
            return arrayOfNulls(size)
        }
    }
}