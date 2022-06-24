package com.example.kakao_app.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kakao_app.MainActivity
import com.example.kakao_app.R


class MainFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =  inflater.inflate(R.layout.fragment_main, container, false)

        mainActivity = context as MainActivity
        // Inflate the layout for this fragment
//        text = v.findViewById(R.id.Text)
        return v
    }

    override fun onStart() {
        super.onStart()


    }
}