package com.example.cakepedia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserManager.db"
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password" // Simpan password (untuk demo ini saja)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_USERNAME + " TEXT UNIQUE,"
                + KEY_PASSWORD + " TEXT" + ")")
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Fungsi untuk menambahkan user baru (bisa dipanggil saat registrasi atau untuk data dummy)
    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_USERNAME, username)
        contentValues.put(
            KEY_PASSWORD,
            password
        ) // HATI-HATI: Menyimpan password plain text tidak aman!
        val success = db.insert(TABLE_USERS, null, contentValues)
        db.close()
        return success // Mengembalikan ID baris baru, atau -1 jika error
    }

    fun isUserExists(username: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(KEY_ID)
        val selection = "$KEY_USERNAME = ?"
        val selectionArgs = arrayOf(username)
        val cursor = db.query(
            TABLE_USERS,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val count = cursor.count
        cursor.close()
        return count > 0
    }

    // Fungsi untuk mengecek kredensial pengguna
    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(KEY_ID)
        val selection = "$KEY_USERNAME = ? AND $KEY_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(
            TABLE_USERS,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0 // True jika user ditemukan dengan username dan password yang cocok
    }
}