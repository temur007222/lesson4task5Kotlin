package com.example.lesson4task5kotlin.Model

import android.os.Parcel
import android.os.Parcelable

class User(var name: String?, var age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name!!)
        p0?.writeInt(age!!)
    }

    @JvmName("getName1")
    fun getName(): String? {
        return name
    }

    @JvmName("getAge1")
    fun getAge(): Int {
        return age
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}