package com.example.kakao_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kakao_app.Adapter.FragmentAdapter
import com.example.kakao_app.kakaoAPI.SecondActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause.*
import com.kakao.sdk.user.UserApiClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 : ViewPager2 = findViewById(R.id.viewpager2)
        val tabLayout : TabLayout = findViewById(R.id.tabLayout)


        viewPager2.apply {
            adapter = FragmentAdapter(context as FragmentActivity)
            // 사용자 스와이프에 화면 전환은 불가능하게 만듬 -> 맵을 이동할 때 발생하는 화면 전환 문제
            isUserInputEnabled = false
        }

        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            when (position){
                0 -> {
                    tab.text = "홈"
                }
                1 -> {
                    tab.text = "동행 페이지"
                }
                2 -> {
                    tab.text = "방명록"
                }
                3 -> {
                    tab.text = "여행일지"
                }
                4 -> {
                    tab.text = "마이 페이지"
                }
            }
        }.attach()
    }
}
