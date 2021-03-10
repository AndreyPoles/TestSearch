package com.search.searchimages.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.search.searchimages.R
import kotlinx.android.synthetic.main.activity_second_screen.*
import kotlinx.android.synthetic.main.tags_item.view.*

class SecondScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val urlGif = intent.getStringExtra("url")

        Glide.with(this)
            .load(urlGif)
            .into(imageViewSecondScreen)

    }
}