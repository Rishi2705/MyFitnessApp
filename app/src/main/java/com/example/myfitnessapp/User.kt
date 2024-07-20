package com.example.myfitnessapp

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.annotation.StringRes
import com.google.common.cache.Weigher

data class User(
    val name: String,
    val phone: String,
    val weight: String,
    val height:String,
    val city: String,
    val state: String
)
