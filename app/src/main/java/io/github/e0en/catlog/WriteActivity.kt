package io.github.e0en.catlog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import java.util.Calendar

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                writeItem()
                finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun writeItem() {
        val categoryField = findViewById<EditText>(R.id.categoryText)
        val category = categoryField.text.asSequence().toString()

        val contentField = findViewById<EditText>(R.id.contentText)
        val content = contentField.text.asSequence().toString()

        val now = Calendar.getInstance().time

        val newLog = CatLog(now, category, content)

        DbHelper(this).insertCatLog(newLog)
    }
}
