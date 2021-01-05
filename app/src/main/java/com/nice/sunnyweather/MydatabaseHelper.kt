package com.nice.sunnyweather


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version)
{
    private val createAccounts = "create table Account (" +
            " id integer primary key autoincrement," +
            "account text," +
            "password text)"



//    private val createCategory = "create table Category (" +
//            " id integer primary key autoincrement," +
//            "category_name text," +
//            "category integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createAccounts)
        //db.execSQL(createCategory)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //db.execSQL("drop table if exists Book")
        //db.execSQL("drop table if exists Category")
        //onCreate(db)

    }


}