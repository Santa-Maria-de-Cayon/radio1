package com.suzdalenko.radio
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_rus_radio.*

class RusRadio : AppCompatActivity()  , View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.rus_radio96 -> { val uris = Uri.parse("http://suzdalenko.com?+russkoe-radio96");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.svoboda -> { val uris = Uri.parse("http://suzdalenko.com?+svoboda");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.rus_radio128 -> { val uris = Uri.parse("http://suzdalenko.com?+russkoe-radio128");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.drug_astraj32 -> { val uris = Uri.parse("http://suzdalenko.com?+drugaya-astrajan32");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.drug_astraj128 -> { val uris = Uri.parse("http://suzdalenko.com?+drugaya-astrajan128");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.shanson -> { val uris = Uri.parse("http://suzdalenko.com?+shanson");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ejo -> { val uris = Uri.parse("http://suzdalenko.com?+ejo-moskvi");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.di -> { val uris = Uri.parse("http://suzdalenko.com?+di-fm");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.yomor -> { val uris = Uri.parse("http://suzdalenko.com?+yumor-fm");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.r90 -> { val uris = Uri.parse("http://suzdalenko.com?+90");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.vesti -> { val uris = Uri.parse("http://suzdalenko.com?+vesti-fm");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.mayak -> { val uris = Uri.parse("http://suzdalenko.com?+mayak");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.komsomol -> { val uris = Uri.parse("http://suzdalenko.com?+komsomol");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ser48 -> { val uris = Uri.parse("http://suzdalenko.com?+serebryaniy-dozd-48");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
                R.id.ser128 -> { val uris = Uri.parse("http://suzdalenko.com?+serebryaniy-dozd-128");val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents); }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rus_radio)

        rus_radio96.setOnClickListener(this)
        svoboda.setOnClickListener(this)
        rus_radio128.setOnClickListener(this)
        drug_astraj32.setOnClickListener(this)
        drug_astraj128.setOnClickListener(this)
        shanson.setOnClickListener(this)
        ejo.setOnClickListener(this)
        di.setOnClickListener(this)
        yomor.setOnClickListener(this)
        r90.setOnClickListener(this)
        vesti.setOnClickListener(this)
        mayak.setOnClickListener(this)
        komsomol.setOnClickListener(this)
        ser48.setOnClickListener(this)
        ser128.setOnClickListener(this)

    }
}
