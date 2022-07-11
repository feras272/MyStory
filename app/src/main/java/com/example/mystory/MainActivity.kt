package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private var textViewUsername:TextView? = null
    private var drawerLayout:DrawerLayout? = null
    private var toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        val username:String = intent.getStringExtra("username").toString()
        textViewUsername?.setText(username)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun connectViews() {
        textViewUsername = findViewById(R.id.tv_username_activity_main)
        drawerLayout = findViewById(R.id.drawer_layout_activity_main)
        toolbar = findViewById(R.id.tool_bar_activity_main)
    }
}