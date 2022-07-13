package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {

    private var editTextNewTitle:EditText? = null
    private var editTextNewSubtitle:EditText? = null
    private var editTextNewDesc:EditText? = null
    private var buttonAddStory:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        fieldsValidation()
    }

    private fun connectViews() {
        editTextNewTitle = findViewById(R.id.et_new_title_activity_add_story)
        editTextNewSubtitle = findViewById(R.id.et_new_subtitle_activity_add_story)
        editTextNewDesc = findViewById(R.id.et_new_desc_activity_add_story)
        buttonAddStory = findViewById(R.id.btn_new_story_activity_add_story)
    }

    private fun fieldsValidation() {
        buttonAddStory?.setOnClickListener {
            val newTitle = editTextNewTitle?.text.toString()
            val newSubtitle = editTextNewSubtitle?.text.toString()
            val newDesc = editTextNewDesc?.text.toString()

            when {
                newTitle.isEmpty() -> {
                    editTextNewTitle?.error = getString(R.string.new_title)
                }
                newSubtitle.isEmpty() -> {
                    editTextNewSubtitle?.error = getString(R.string.new_subtitle)
                }
                newDesc.isEmpty() -> {
                    editTextNewDesc?.error = getString(R.string.new_desc)
                }
                else -> {
                    // add new story here
                    this.finish()
                    val intent:Intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("new_title", newTitle)
                    intent.putExtra("new_subtitle", newSubtitle)
                    intent.putExtra("new_desc", newDesc)
                    startActivity(intent)
                }
            }
        }
    }
}