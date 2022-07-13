package com.example.kakao_app.GuestBook.SearchPackage

import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.kakao_app.R


class ImageClick_Actitivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_click_actitivty)

        val titleImage: ImageView = findViewById(R.id.titleimage)
        titleImage.setOnClickListener {

        }

        val CustomDialog = ProfileDialog(this)
        val button: View = findViewById(R.id.button)
        button.setOnClickListener {
            CustomDialog.show()
        }

        // 버튼 클릭을 하면 서버에 코맨트 값 이미지 값 전송 확인  / 사진은 1개만 넣는다
        // 타이틀 텍스트에 메인에 있는 place 값을 불러와 넣어준다



    }
}
