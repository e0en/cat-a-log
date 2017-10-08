package io.github.e0en.catlog

import android.content.ContentValues
import android.provider.BaseColumns
import java.util.*

data class CatLog(val createdAt: Date, val category: String, val content: String): BaseColumns {
    companion object {
        val tableName = "cat_logs"

        val _ID = BaseColumns._ID
        val _COUNT = BaseColumns._COUNT
        val COL_CATEGORY = "category"
        val COL_CONTENT = "content"
        val COL_CREATED_AT = "created_at"
    }

    val contentValues = {
        val cv = ContentValues()
        cv.put(COL_CREATED_AT, createdAt.time)
        cv.put(COL_CATEGORY, category)
        cv.put(COL_CONTENT, content)
        cv
    }
}

