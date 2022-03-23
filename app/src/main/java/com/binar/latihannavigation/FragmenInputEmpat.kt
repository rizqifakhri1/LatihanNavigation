package com.binar.latihannavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FragmenInputEmpat(
    val usia : Int,
    val alamat : String,
    val pekerjaan: String
    ) : Parcelable
