package com.example.myfitnessapp

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

object FirebaseInstance {
    val db = Firebase.firestore
}