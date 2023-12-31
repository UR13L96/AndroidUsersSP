package com.olascoaga.userssp

data class User (
    val id: Long,
    var name: String,
    var lastName: String,
    var url: String
) {
    fun getFullname(): String = "$name $lastName"
}