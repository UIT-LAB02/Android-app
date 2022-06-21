package com.example.kakao_app.kakaoAPI

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "a81f58772bd67ab645f65c8b16bc07e3")
    }

}