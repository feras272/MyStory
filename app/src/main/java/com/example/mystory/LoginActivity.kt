package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlin.concurrent.fixedRateTimer

class LoginActivity : AppCompatActivity() {

    private var editTextUsername:EditText? = null
    private var editTextPassword:EditText? = null
    private var buttonLogin:Button? = null
    private var checkBoxTerms:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()
        //checkFields()
    }

    private fun connectViews() {
        editTextUsername = findViewById(R.id.et_username_activity_login)
        editTextPassword = findViewById(R.id.et_password_activity_login)
        buttonLogin = findViewById(R.id.btn_login_activity_login)
        checkBoxTerms = findViewById(R.id.cb_terms_activity_main)
    }

    private fun login() {

        val userArray:ArrayList<User> = ArrayList()
        userArray.add(User("test@test.com", "1234"))
        userArray.add(User("test2@test.com", "1234"))
        userArray.add(User("test3@test.com", "1234"))

        buttonLogin?.setOnClickListener {

            val usernameData = editTextUsername?.text.toString() // user input username
            val passwordData = editTextPassword?.text.toString() // user input password

            val user = User(usernameData, passwordData) // new object from the user input

            // array data - checking the user input data
            for(data in userArray) {
                if(data.username == user.username && data.password == user.password) {
                    //Toast.makeText(this, "Welcome ${user.username}", Toast.LENGTH_LONG).show()
                    finish()
                    val intent:Intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username",data.username)
                    startActivity(intent)
                    break
                } else {
                    Toast.makeText(this, "Check your data", Toast.LENGTH_LONG).show()
                }
            }

        }

    }

    private fun checkFields() {
        buttonLogin?.setOnClickListener {
            if(editTextUsername?.text?.isEmpty() == true) {
//            Toast.makeText(this, "Enter your data", Toast.LENGTH_LONG).show()
                editTextUsername?.setError("Enter your username")
            } else if(editTextPassword?.text?.isEmpty() == true) {
                editTextPassword?.error = "Enter your password"
            }
        }

    }
}