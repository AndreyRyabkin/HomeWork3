package ru.netology.androidhw3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.androidhw3.dto.Post
import ru.netology.androidhw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likeByMe = false,
            counter = 4999,
            numberView = 1_500_500,
            repost = 15_999

        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likes.text = format(post.counter)
            numberOfVies.text = format(post.numberView)
            textView.text = format(post.repost)


            imageView.setOnClickListener {
                post.repost++
                textView.text = format(post.repost)
            }
            root.setOnClickListener {

            }
           avatar.setOnClickListener {

           }



            likesView.setImageResource(
                if(post.likeByMe){
                    R.drawable.like_red
                } else { R.drawable.like_svgrepo_com}
            )


            likesView.setOnClickListener {

                post.likeByMe = !post.likeByMe
                if (post.likeByMe) {
                    post.counter++
                } else {
                    post.counter--
                }
                likes.text = format(post.counter)
                likesView.setImageResource(
                    if (post.likeByMe) {
                        R.drawable.like_red
                    } else {
                        R.drawable.like_svgrepo_com
                    }
                )
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}