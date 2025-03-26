package ru.netology.androidhw3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.androidhw3.dto.Post

class PostRepositoryinMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        published = "21 мая в 18:36",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        likeByMe = false,
        counter = 4999,
        numberView = 1_500_500,
        repost = 15_999
    )

    private var data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data

    override fun like() {
        post = post.copy(likeByMe = !post.likeByMe)
        post = if (post.likeByMe) {
            post.copy(counter = post.counter + 1)
        } else {
            post.copy(counter = post.counter - 1)
        }
        data.value = post
    }

    override fun repost() {
        post = post.copy(repost = post.repost + 1)
        data.value = post
    }
}