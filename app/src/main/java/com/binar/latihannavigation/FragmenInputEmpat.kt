package com.binar.latihannavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FragmenInputEmpat(
    val gajiOrtu : Int,
    val penghasilan : Int,
    val tanggungan: Int
    ) : Parcelable
