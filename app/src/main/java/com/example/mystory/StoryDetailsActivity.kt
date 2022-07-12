package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity : AppCompatActivity() {

    private var textViewStoryTitle:TextView? = null
    private var textViewStoryDesc:TextView? = null
    private var toolbarStory:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()

        setSupportActionBar(toolbarStory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Receive variables
        val storyTitle = intent.getStringExtra("title").toString()
//        textViewStoryTitle?.text = storyTitle
        val storyDesc = intent.getStringExtra("desc").toString()

        supportActionBar?.title = storyTitle
        textViewStoryDesc?.text = storyDesc
        toolbarStory?.setNavigationOnClickListener {
            onBackPressed()
        }

        textViewStoryDesc?.movementMethod = ScrollingMovementMethod()

    }

    private fun connectViews() {
        textViewStoryTitle = findViewById(R.id.tv_title_story_details_activity)
        textViewStoryDesc = findViewById(R.id.tv_desc_activity_story_details)
        toolbarStory = findViewById(R.id.toolbar_activity_story_details)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId) {
//            android.R.id.home -> {
//
//                true
//            }
//            else -> true
//        }
//    }
}