package ru.netology.androidhw3.repository

import androidx.lifecycle.LiveData
import ru.netology.androidhw3.dto.Post
interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun repost()
}