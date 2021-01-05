package com.nice.sunnyweather

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nice.sunnyweather.Denglu
import com.nice.sunnyweather.logic.model.Weather
import com.nice.sunnyweather.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.layout_denglu.*

class Denglu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_denglu)

        val dbHelper = MyDatabaseHelper(this, "Accounts.db", 1)



            dbHelper.writableDatabase




            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply{
                //第一个用户
                put("id", 1)
                put("account", "SBH")
                put("password", "123")

            }

            db.insert("Account", null, values1)
        //第二个用户
            val values2 = ContentValues().apply {
                put("id", 2)
                put("account", "WJQ")
                put("password", "123")
            }
            db.insert("Account", null, values2)
        val values3 = ContentValues().apply{
            //第三个用户
            put("id", 3)
            put("account", "YZJ")
            put("password", "123")

        }
        db.insert("Account", null, values3)
        //第四个用户
        val values4 = ContentValues().apply {
            put("id", 4)
            put("account", "HYL")
            put("password", "123")
        }
        db.insert("Account", null, values4)




        Zhuce.setOnClickListener{
            val intent = Intent(this, ZhuceActivity::class.java)
            startActivity(intent)

        }

        Denglu.setOnClickListener {
            val db = dbHelper.writableDatabase
            val acc = account.text.toString()
            val pas = password.text.toString()

            Log.d("输入","输入的账号是$acc，密码是$pas")

            //查找表中匹配到正确账号密码的条目
            val cursor = db.query("Account", null, null, null, null, null, null)
            if(cursor.moveToNext())
            {
                do {
                    val correctAccount = cursor.getString(cursor.getColumnIndex("account"))
                    val correctPassword = cursor.getString(cursor.getColumnIndex("password"))
                    Log.d("account", correctAccount)
                    Log.d("password", correctPassword)
                    if(acc.equals(correctAccount) && pas.equals(correctPassword))
                    {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else
                        Log.d("error","账号或密码错误")
                } while (cursor.moveToNext())

            }
            cursor.close()

        }





    }
}