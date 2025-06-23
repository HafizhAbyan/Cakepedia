package com.example.cakepedia.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cakepedia.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Ambil referensi EditText dan ImageView
        val etName = view.findViewById<EditText>(R.id.et_name)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPhone = view.findViewById<EditText>(R.id.et_phone)

        val btnEditName = view.findViewById<ImageView>(R.id.btn_edit_name)
        val btnEditEmail = view.findViewById<ImageView>(R.id.btn_edit_email)
        val btnEditPhone = view.findViewById<ImageView>(R.id.btn_edit_phone)

        // Saat tombol edit ditekan, aktifkan kolom input
        btnEditName.setOnClickListener {
            etName.isEnabled = true
            etName.isFocusableInTouchMode = true
            etName.requestFocus()
        }

        btnEditEmail.setOnClickListener {
            etEmail.isEnabled = true
            etEmail.isFocusableInTouchMode = true
            etEmail.requestFocus()
        }

        btnEditPhone.setOnClickListener {
            etPhone.isEnabled = true
            etPhone.isFocusableInTouchMode = true
            etPhone.requestFocus()
        }

        return view
    }
}
