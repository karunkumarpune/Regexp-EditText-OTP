package com.regex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import ru.nixan.regexpformatter.RegExpFormatter

class MainActivity  : AppCompatActivity() {
   
   val regExpFormatter = RegExpFormatter("\\d{4} - \\d{4} - \\d{4} ")
   lateinit var edt:EditText
   
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      edt= findViewById<EditText>(R.id.testEdit)
      edt.addTextChangedListener(regExpFormatter)
      edt.setRawInputType(regExpFormatter.inputType)
      
      (findViewById<Button>(R.id.triggerButton)).setOnClickListener {
         
         val value=edt.text.toString()
         if (regExpFormatter.check(value)) {
             val finagles=value.replace(" - ","")
            
            
            Toast.makeText(this, "OK", Toast.LENGTH_LONG).show()
            Log.d("TAGS",""+ finagles)
         } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
         }
      }
   }
}