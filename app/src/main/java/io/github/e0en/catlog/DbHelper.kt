package io.github.e0en.catlog

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, "cat-a-log.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    private val SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + CatLog.tableName + " (" +
        CatLog._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        CatLog.COL_CATEGORY + " TEXT," +
        CatLog.COL_CONTENT + " TEXT," +
        CatLog.COL_CREATED_AT + " LONG" +
        ")"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CatLog.tableName

    fun insertCatLog(log: CatLog) {
        val db = this.writableDatabase
        val values = log.contentValues()
        db.insert(CatLog.tableName, null, values)
        db.close()
    }
}