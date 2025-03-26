package ru.netology.androidhw3.dto

data class Post(
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likeByMe: Boolean,
    var counter: Int,
    var numberView: Int,
    var repost: Int,



)
