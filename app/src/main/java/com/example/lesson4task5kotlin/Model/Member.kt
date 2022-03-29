package com.example.lesson4task5kotlin.Model

import android.os.Parcel
import android.os.Parcelable


class Member(var name: String?, var age: Int) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<Member> {
        override fun createFromParcel(parcel: Parcel): Member {
            return Member(parcel)
        }

        override fun newArray(size: Int): Array<Member?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}