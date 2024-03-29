package com.example.clonetelegram.models

data class CommonModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",
    var state: String = "",

    var text: String = "",
    var type: String = "",
    var from: String = "",
    var timeStamp: Any = "",
    var fileUrl: String = "empty"





) {
    override fun equals(other: Any?): Boolean {
        return (other as CommonModel).id == id
    }
}