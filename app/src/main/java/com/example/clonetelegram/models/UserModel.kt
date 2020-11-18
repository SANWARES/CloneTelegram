package com.example.clonetelegram.models

data class UserModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",
    var state: String = ""

)