package com.example.lesson4task5kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4task5kotlin.Model.Member
import com.example.lesson4task5kotlin.Model.User

class MainActivity : AppCompatActivity() {
    private val TAG = "Message"
    var LAUNCHER_DETAIL = 112
    var tv_home: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v(TAG, "$requestCode     $resultCode")
        if (requestCode == LAUNCHER_DETAIL) {
            if (resultCode == RESULT_OK) {
                val member: Member? = data!!.getParcelableExtra<Parcelable>("member") as Member?
                Log.v(TAG, member.toString())
                tv_home?.setText(member.toString())
            }
        }
    }

    fun initView() {
        tv_home = findViewById(R.id.tv_home)
        val b_detail = findViewById<Button>(R.id.b_detail)
        b_detail.setOnClickListener {
            val user = User("Temur", 18)
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("user", user)
            startActivityForResult(
                intent, LAUNCHER_DETAIL
            )
        }
    }
}