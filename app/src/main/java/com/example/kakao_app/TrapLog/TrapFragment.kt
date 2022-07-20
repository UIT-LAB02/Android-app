package com.example.kakao_app.TrapLog

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kakao_app.MainActivity
import com.example.kakao_app.R
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

val PERMISSIONS_REQUEST_CODE = 100
var REQUIRED_PERMISSIONS = arrayOf( Manifest.permission.ACCESS_FINE_LOCATION)

class TrapFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var mapView : MapView
    lateinit var  mapViewContainer: ViewGroup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_trap, container, false)

        return view
    }

    override fun onStart() {
        super.onStart()
        mainActivity = context as MainActivity
        mapViewContainer = mainActivity.findViewById(R.id.map_view) as ViewGroup



        val button: Button = mainActivity.findViewById(R.id.button4)

        button.setOnClickListener {
            val permissionCheck = ContextCompat.checkSelfPermission(
                mainActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                val lm: LocationManager =
                    mainActivity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                try {
                    val userNowLocation: Location =
                        lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
                    val uLatitude = userNowLocation.latitude
                    val uLongitude = userNowLocation.longitude
                    val uNowPosition =
                        MapPoint.mapPointWithGeoCoord(uLatitude, uLongitude)

                    val maker = MapPOIItem()
                    maker.itemName = "현재 위치"
                    maker.mapPoint = uNowPosition
                    maker.markerType = MapPOIItem.MarkerType.BluePin
                    maker.selectedMarkerType = MapPOIItem.MarkerType.RedPin
                    mapView.addPOIItem(maker)

                    mapView.setMapCenterPoint(uNowPosition, true)
                } catch (e: NullPointerException) {
                    Log.e("LOCATION_ERROR", e.toString())
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        ActivityCompat.finishAffinity(mainActivity)
                    } else {
                        ActivityCompat.finishAffinity(mainActivity)
                    }


                    val intent = Intent(mainActivity, TrapFragment::class.java)
                    startActivity(intent)
                    System.exit(0)
                }
            } else {
                Toast.makeText(mainActivity, "위치 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(
                    mainActivity,
                    REQUIRED_PERMISSIONS,
                    PERMISSIONS_REQUEST_CODE
                )
            }
        }
    }


    override fun onResume() {
        super.onResume()
        // 화면으로 복귀했을 경우 다시 뷰를 활성화 시킨다
        mapView = MapView(activity)
        mapViewContainer.addView(mapView)
    }


    override fun onPause() {
        super.onPause()
        // 다른 화면으로 넘어갔을 경우 종료 시키지 않고 멈춤 상태를 만든다
        mapViewContainer.removeView(mapView)
    }
}