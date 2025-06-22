package com.example.cakepedia.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.cakepedia.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tidak pakai parameter tambahan
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Tampilkan layout fragment_homes.xml
        return inflater.inflate(R.layout.fragment_home
            , container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil referensi tiap card
        val card1 = view.findViewById<View>(R.id.card1)
        val card2 = view.findViewById<View>(R.id.card2)
        val card3 = view.findViewById<View>(R.id.card3)
        val card4 = view.findViewById<View>(R.id.card4)

        // Isi gambar dan judul sesuai
        card1.findViewById<ImageView>(R.id.imageCake).setImageResource(R.drawable.black)
        card1.findViewById<TextView>(R.id.titleCake).text = "Black Forest Cake"

        card2.findViewById<ImageView>(R.id.imageCake).setImageResource(R.drawable.royal)
        card2.findViewById<TextView>(R.id.titleCake).text = "Royal Fudge Cake"

        card3.findViewById<ImageView>(R.id.imageCake).setImageResource(R.drawable.classic)
        card3.findViewById<TextView>(R.id.titleCake).text = "Classic Sansrival"

        card4.findViewById<ImageView>(R.id.imageCake).setImageResource(R.drawable.custom)
        card4.findViewById<TextView>(R.id.titleCake).text = "Custom Cake"
    }
}
