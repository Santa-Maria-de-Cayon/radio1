package com.suzdalenko.radio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_esp_radio.*
import kotlinx.android.synthetic.main.activity_rus_radio.*

class EspRadio : AppCompatActivity()  , View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.dial -> { val uris = Uri.parse("http://suzdalenko.com?+cadena-dial");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.los40 -> { val uris = Uri.parse("http://suzdalenko.com?+los-40");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.los40clas -> { val uris = Uri.parse("http://suzdalenko.com?+los-40-classic");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.cien -> { val uris = Uri.parse("http://suzdalenko.com?+cadena-100");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.rock -> { val uris = Uri.parse("http://suzdalenko.com?+rock");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.loca -> { val uris = Uri.parse("http://suzdalenko.com?+loca-fm");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.rac1 -> { val uris = Uri.parse("http://suzdalenko.com?+rac1");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.onda -> { val uris = Uri.parse("http://suzdalenko.com?+onda-cero");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ibiza -> { val uris = Uri.parse("http://suzdalenko.com?+ibiza");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.rne -> { val uris = Uri.parse("http://suzdalenko.com?+rne");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.inter -> { val uris = Uri.parse("http://suzdalenko.com?+inter-economia");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ser -> { val uris = Uri.parse("http://suzdalenko.com?+ser");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ib -> { val uris = Uri.parse("http://suzdalenko.com?+ibiza-sonica");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.vinilo -> { val uris = Uri.parse("http://suzdalenko.com?+vinilo");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.cope -> { val uris = Uri.parse("http://suzdalenko.com?+cope");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }

                R.id.max -> { val uris = Uri.parse("http://suzdalenko.com?+maxima");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.hit -> { val uris = Uri.parse("http://suzdalenko.com?+hit");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.kiss -> { val uris = Uri.parse("http://suzdalenko.com?+kiss");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.gay -> { val uris = Uri.parse("http://suzdalenko.com?+gay");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.fresca -> { val uris = Uri.parse("http://suzdalenko.com?+la-fresca");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.holi -> { val uris = Uri.parse("http://suzdalenko.com?+holidaygym");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.xxx -> { val uris = Uri.parse("http://suzdalenko.com?+xxx-rock");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.radiole -> { val uris = Uri.parse("http://suzdalenko.com?+radiole");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.localatino -> { val uris = Uri.parse("http://suzdalenko.com?+loca-latino");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esp_radio)

        dial.setOnClickListener(this)
        los40.setOnClickListener(this)
        los40clas.setOnClickListener(this)
        cien.setOnClickListener(this)
        rock.setOnClickListener(this)
        loca.setOnClickListener(this)
        rac1.setOnClickListener(this)
        onda.setOnClickListener(this)
        ibiza.setOnClickListener(this)
        rne.setOnClickListener(this)
        inter.setOnClickListener(this)
        ser.setOnClickListener(this)
        ib.setOnClickListener(this)
        vinilo.setOnClickListener(this)
        cope.setOnClickListener(this)
        max.setOnClickListener(this)
        hit.setOnClickListener(this)
        kiss.setOnClickListener(this)
        gay.setOnClickListener(this)
        fresca.setOnClickListener(this)
        holi.setOnClickListener(this)
        xxx.setOnClickListener(this)
        radiole.setOnClickListener(this)
        localatino.setOnClickListener(this)






    }
}
