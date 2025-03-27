package ru.netology.androidhw3

import androidx.lifecycle.ViewModel
import ru.netology.androidhw3.repository.PostRepositoryinMemoryImpl

class PostViewModel: ViewModel() {
    private val repository = PostRepositoryinMemoryImpl()
    val data = repository.get()
    fun likePost() = repository.like()
    fun repostPost() = repository.repost()
}
