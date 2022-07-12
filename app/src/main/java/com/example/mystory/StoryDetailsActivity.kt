package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StoryDetailsActivity : AppCompatActivity() {

    private var textViewStoryTitle:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()

        val storyTitle = intent.getStringExtra("title").toString()
        textViewStoryTitle?.text = storyTitle

    }

    private fun connectViews() {
        textViewStoryTitle = findViewById(R.id.tv_title_story_details_activity)
    }
}