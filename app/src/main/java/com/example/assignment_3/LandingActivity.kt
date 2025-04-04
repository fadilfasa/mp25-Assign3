package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val user = intent.getParcelableExtra<User>("user_data")
        val welcomeTextView = findViewById<TextView>(R.id.welcome_message)
        val logoutButton = findViewById<Button>(R.id.logout_button)

        if (user != null) {
            val welcomeMessage = "Selamat datang, ${user.name}!"
            welcomeTextView.text = welcomeMessage
            Toast.makeText(this, welcomeMessage, Toast.LENGTH_LONG).show()
        } else {
            welcomeTextView.text = "Selamat datang!"
        }

        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
