package com.example.kakao_app.kakaoAPI

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "d906dbee734d0e10d04ee4116fd7a0d7")
    }

}