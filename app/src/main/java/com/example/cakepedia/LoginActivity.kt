package com.example.cakepedia // Ganti dengan package Anda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Sembunyikan ActionBar/Toolbar jika ada
        supportActionBar?.hide()

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            // Di sini Anda bisa menambahkan validasi username/password
            // Untuk sekarang, kita langsung pindah ke MainActivity

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup LoginActivity agar tidak bisa kembali dengan tombol back
        }
    }
}