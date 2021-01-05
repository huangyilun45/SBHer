package com.nice.sunnyweather

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nice.sunnyweather.SunnyWeatherApplication.Companion.context
import kotlinx.android.synthetic.main.layout_zhuce.*

class ZhuceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_zhuce)

        val dbHelper = MyDatabaseHelper(this, "Accounts.db", 1)


        Wanchengzhuce.setOnClickListener{
            val db = dbHelper.writableDatabase
            val acc = account.text
            val pas = password.text
            val values1 = ContentValues().apply {
                //将账号和密码的数据插入
                put("account", "$acc")
                put("password", "$pas")
            }
            db.insert("Account", null, values1)
            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Denglu::class.java)
            startActivity(intent)
        }
    }
}