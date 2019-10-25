package com.suzdalenko.radio
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rus.setOnClickListener(this)
        spain.setOnClickListener(this)

     //   val uris = Uri.parse("http://suzdalenko.com?+russkoe-radio96");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents);
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.rus ->   { val intent = Intent(this, RusRadio::class.java); startActivity(intent) }
                R.id.spain -> { val intent = Intent(this, EspRadio::class.java); startActivity(intent) }
            }
        }
    }




}
