package com.example.cakepedia.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cakepedia.R
import androidx.navigation.fragment.findNavController
import android.widget.ImageView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class searchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgcoklat = view.findViewById<ImageView>(R.id.navigation_kuecoklat)
        imgcoklat.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuecoklat)
        }

        val imglebaran = view.findViewById<ImageView>(R.id.navigation_kuelebaran)
        imglebaran.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuelebaran)
        }

        val imgbasah = view.findViewById<ImageView>(R.id.navigation_kuebasah)
        imgbasah.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuebasah)
        }

        val imgkukus = view.findViewById<ImageView>(R.id.navigation_kuekukus)
        imgkukus.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuekukus)
        }

        val imgmodern = view.findViewById<ImageView>(R.id.navigation_kuemodern)
        imgmodern.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuemodern)
        }

        val imgtradisional = view.findViewById<ImageView>(R.id.navigation_kuetradisional)
        imgtradisional.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_navigation_kuetradisional)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            searchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}