package com.example.kakao_app.GuestBook.SearchPackage

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_app.R

class SearchActivity : AppCompatActivity() {

    // 검색값을 저장해서 값을 전송 -> input 값을 저장해 전송? + 검색후 텍스트 저장할 변수도 생성
    // 값을 받아온다 쪽에 서버에서 받은 대표값을 넣어준다
    // 리사이클러뷰쪽에 사진들을 출력한다 출력할때에는 서버에서 받아온 값을 리스트에 분리 최대 5개
    // 분리된 리스트 값을 for 반복문으로 한개씩 인덱스 처리해 준다 -> 추후 인덱스 처리를 랜덤 ex) 로또 같은 번호 출력 알고리즘
    // 처리된 인덱스 번호들을 각각의 틀에 넣어 출력

    // 받아온 사진 데이터를 저장하는 곳 실행될때 동작해야함
    val DataList = arrayListOf(
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),
        Data(R.drawable.dog),

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val textView: TextView = findViewById(R.id.addText)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)

        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.adapter = SearchAdapter(DataList)

        textView.setOnClickListener {
            val intent = Intent(this, ImageClick_Actitivty::class.java)
            startActivity(intent)
        }
    }
}