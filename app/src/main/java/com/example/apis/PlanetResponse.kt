package com.example.apis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PlanetResponse (
    val results: MutableList<Planet>
) : Parcelable






