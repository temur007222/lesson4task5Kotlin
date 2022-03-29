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

class SecondActivity : AppCompatActivity() {
    private val TAG = SecondActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    fun initView() {
        val tv_detail = findViewById<TextView>(R.id.tv_detail)
        val b_exit = findViewById<Button>(R.id.b_exit)
        b_exit.setOnClickListener {
            val member = Member("Temur", 18)
            closeDetail(member)
        }
        val user: User? = intent.getParcelableExtra<Parcelable>("user") as User?
        Log.d(TAG, user.toString())
        tv_detail.text = user.toString()
    }

    fun closeDetail(member: Member?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("member", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}