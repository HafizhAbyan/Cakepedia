package com.example.cakepedia // Ganti dengan package Anda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var dbHelper: DatabaseHelper

    // --- Data pengguna untuk tes ---
    private val TEST_USERNAME = "admin"
    private val TEST_PASSWORD = "password123"
    // --- Akhir data pengguna untuk tes ---

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Pastikan nama layout XML Anda benar

        // Sembunyikan ActionBar/Toolbar jika ada (opsional, bisa Anda pertahankan atau hapus)
        supportActionBar?.hide()

        // Inisialisasi View
        usernameEditText = findViewById(R.id.usernameEditText) // Sesuaikan dengan ID di XML Anda
        passwordEditText = findViewById(R.id.passwordEditText) // Sesuaikan dengan ID di XML Anda
        loginButton = findViewById(R.id.loginButton)       // Sesuaikan dengan ID di XML Anda

        // Inisialisasi DatabaseHelper
        dbHelper = DatabaseHelper(this)

        // --- TAMBAHKAN PENGGUNA TES DI SINI ---
        addTestUserIfNeeded()
        // --- AKHIR PENAMBAHAN PENGGUNA TES ---

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (dbHelper.checkUser(username, password)) {
                    // Login Berhasil
                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                    //Navigasi ke activity berikutnya (misalnya MainActivity)
                    // Anda bisa aktifkan ini jika sudah ada MainActivity
                     val intent = Intent(this, MainActivity::class.java)
                     intent.putExtra("USERNAME", username) // Opsional: kirim data username
                     startActivity(intent)
                     finish() // Tutup LoginActivity agar tidak bisa kembali dengan tombol back
                } else {
                    // Login Gagal
                    Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Menambahkan pengguna tes ke database jika belum ada.
     * Ini akan dijalankan sekali saat Activity dibuat.
     */
    private fun addTestUserIfNeeded() {

        // Setelah Anda menambahkan isUserExists di DatabaseHelper.kt:
        if (!dbHelper.isUserExists(TEST_USERNAME)) { // Anda perlu menambahkan isUserExists ke DatabaseHelper
            val id = dbHelper.addUser(TEST_USERNAME, TEST_PASSWORD)
            if (id != -1L) {
                Toast.makeText(this, "User tes '$TEST_USERNAME' ditambahkan.", Toast.LENGTH_SHORT)
                    .show()
                Log.d(
                    "LoginActivity",
                    "User tes '$TEST_USERNAME' berhasil ditambahkan dengan ID: $id"
                )
            } else {
                Toast.makeText(
                    this,
                    "Gagal menambahkan user tes '$TEST_USERNAME'. Mungkin sudah ada atau error lain.",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("LoginActivity", "Gagal menambahkan user tes '$TEST_USERNAME'.")
            }
        }

        // Pastikan DatabaseHelper Anda memiliki fungsi isUserExists seperti ini:
        // (Tambahkan ini ke dalam class DatabaseHelper di file DatabaseHelper.kt Anda)
        /*
    }
    */
    }
}