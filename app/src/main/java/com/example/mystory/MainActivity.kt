package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var textViewUsername:TextView? = null
    private var drawerLayout:DrawerLayout? = null
    private var toolbar:Toolbar? = null
    private var navigationView:NavigationView? = null
    private var recyclerViewStories:RecyclerView? = null
    private var buttonAddStory:FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        val username:String = intent.getStringExtra("username").toString()
        textViewUsername?.setText(username)

        // if null view or variable does not contain !! it will not work
        setSupportActionBar(toolbar!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        updateUsernameInHeader(username)
        drawerClicks()
        openAddStoryActivity()
        displayStories()

    }

    private fun connectViews() {
        textViewUsername = findViewById(R.id.tv_username_activity_main)
        drawerLayout = findViewById(R.id.drawer_layout_activity_main)
        toolbar = findViewById(R.id.tool_bar_activity_main)
        navigationView = findViewById(R.id.nav_view_activity_main)
        recyclerViewStories = findViewById(R.id.rv_stories_activity_main)
        buttonAddStory = findViewById(R.id.fab_add_story_activity_main)
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun updateUsernameInHeader(username:String?) {
        val headerView = navigationView?.getHeaderView(0)
        val textViewUsername = headerView?.findViewById<TextView>(R.id.tv_email_activity_main)
        textViewUsername?.text = username
    }

    private fun drawerClicks() {
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()
                    val intent:Intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> true
            }

        }
    }

    private fun openAddStoryActivity() {
        buttonAddStory?.setOnClickListener {
            val intent:Intent = Intent(this, AddStoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayStories() {
        val storiesArray:ArrayList<Story> = ArrayList<Story>()
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", getString(R.string.desc1)))
        storiesArray.add(Story("My Story about learning programming"
            , "This is subtitle", "this bootcamp teach me how I search for what I need"))
        storiesArray.add(Story("How my story get load"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("Kotlin is fun"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))
        storiesArray.add(Story("This is my first Story"
            , "This is subtitle", "Welcome to my story, I will show you how I learned"))

        val customAdapter:CustomAdapter = CustomAdapter(storiesArray, this)
        recyclerViewStories?.adapter = customAdapter

        if(intent.getStringExtra("new_title") != null) {
            val title = intent.getStringExtra("new_title").toString()
            val subtitle = intent.getStringExtra("new_subtitle").toString()
            val desc = intent.getStringExtra("new_desc").toString()

            val story:Story = Story(title!!, subtitle!!, desc!!)

            storiesArray.add(story)
            customAdapter.notifyDataSetChanged()
        }

    }

}