package com.coen.mad_w6_recipe.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Recipe (
        val publisher: String,
        val f2fUrl: String,
        val title: String,
        val sourceUrl: String,
        val recipeId: String,
        val imageUrl: String,
        val socialRank: String,
        val publisherUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(publisher)
        parcel.writeString(f2fUrl)
        parcel.writeString(title)
        parcel.writeString(sourceUrl)
        parcel.writeString(recipeId)
        parcel.writeString(imageUrl)
        parcel.writeString(socialRank)
        parcel.writeString(publisherUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}
