package ru.netology.androidhw3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.androidhw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likes.text = format(post.counter)
                numberOfVies.text = format(post.numberView)
                textView.text = format(post.repost)

                imageView.setOnClickListener {
                    viewModel.repostPost()
                }



                likesView.setImageResource(
                    if (post.likeByMe) {
                        R.drawable.like_red
                    } else {
                        R.drawable.like_svgrepo_com
                    }
                )

                likesView.setOnClickListener {
                    viewModel.likePost()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}