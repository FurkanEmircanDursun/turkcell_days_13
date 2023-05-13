package com.example.turkcell_days_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.turkcell_days_13.MainActivity.Companion.noteList
import com.example.turkcell_days_13.models.Note

class DetailActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var detailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView=findViewById(R.id.titleTextView)
        detailTextView=findViewById(R.id.detailTextView)


      var index=  intent.getLongExtra("index",0)

        Log.d("my data", noteList?.get(index.toInt()).toString())


        titleTextView.setText(noteList!!.get(index.toInt()).title)
        detailTextView.setText(noteList!!.get(index.toInt()).detail)

    }
}