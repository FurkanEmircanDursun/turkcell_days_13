package com.example.turkcell_days_13

import android.app.DatePickerDialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.turkcell_days_13.models.Note
import java.util.Calendar

class MainActivity : AppCompatActivity() {


    lateinit var btnDate: Button
    lateinit var btnSave: Button
    lateinit var editTextTitle:EditText
    lateinit var editTextDetail:EditText
    lateinit var listView:ListView

    lateinit var db: DB

    var selectDate = ""
companion object{


      var  noteList:List<Note>?=null
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave = findViewById(R.id.btnSave)
        btnDate = findViewById(R.id.btnDate)
        editTextTitle=findViewById(R.id.editTextTitle)
        editTextDetail=findViewById(R.id.editTextDetail)


        db = DB(this)

        listView = findViewById(R.id.my_listview)


         noteList = db.allNote()
        val titleList = ArrayList<String>()
        for (note in noteList!!) {
            titleList.add(note.title)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, titleList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->


            intent= Intent(this,DetailActivity::class.java)
            intent.putExtra("index",id)
            startActivity(intent)
            Log.d("title index",id.toString())

        }

        val calender = Calendar.getInstance()
        btnDate.setOnClickListener(View.OnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    Log.d("i", i.toString()) // yıl
                    Log.d("i2", (i2 + 1).toString()) // ay
                    Log.d("i3", i3.toString()) // gün
                    var ay = "${i2+1}"
                    if ( i2+1 < 10 ) {
                        ay = "0${i2+1}"
                    }
                    selectDate = "$i3.$ay.$i"
                },
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH),
            )
            datePickerDialog.show()
        })

        btnSave.setOnClickListener {

            if ( selectDate != "" &&editTextTitle.text.toString()!=""&&editTextDetail.text.toString()!="") {


                var status = db.addNote(editTextTitle.text.toString(), editTextDetail.text.toString(), selectDate)
                Log.d("status", status.toString())
                editTextTitle.setText("")
                editTextDetail.setText("")
                selectDate = ""
                val noteList = db.allNote()
                val titleList = ArrayList<String>()
                for (note in noteList) {
                    titleList.add(note.title)
                }


                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,titleList)

                listView.adapter = adapter

            }else {
                Toast.makeText(this, "Please fill all areas!", Toast.LENGTH_LONG).show()
            }

        }



    }
}