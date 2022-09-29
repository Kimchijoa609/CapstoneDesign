package com.junki.capstone_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraViewBtn = findViewById<Button>(R.id.navStartBtn)
        cameraViewBtn.setOnClickListener {
            TedPermission.create()
                .setPermissionListener(object : PermissionListener {
                    override fun onPermissionGranted() {
                        startActivity(Intent(this@MainActivity, CameraActivity::class.java))
                        finish()
                    }

                    override fun onPermissionDenied(deniedPermissions: List<String>) {
                        Toast.makeText(
                            this@MainActivity,
                            "권한을 허가해주세요.",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                    }

                })
                .setDeniedMessage("앱을 실행하려면 권한을 허가하셔야합니다.")
                .setPermissions(android.Manifest.permission.CAMERA)
                .check()
            println("hi")
        }
    }
}
