package com.suzdalenko.radio
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnClickListener{
    lateinit var mAdView : AdView
    lateinit var layoutParams : RelativeLayout.LayoutParams
    lateinit var sv : ScrollView
    lateinit var linAds : LinearLayout
    var heitLinAds = 0

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rus.setOnClickListener(this)
        spain.setOnClickListener(this)

        sv = findViewById(R.id.sv)
        linAds = findViewById(R.id.linAds)
        MobileAds.initialize(this) {}


        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        Log.d("tag", "start start")
        layoutParams = sv.getLayoutParams() as RelativeLayout.LayoutParams



        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                sv.post {
                    heitLinAds = linAds.height + 3
                    layoutParams.setMargins(0, 0, 0, heitLinAds)
                    sv.setLayoutParams(layoutParams)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.rus ->   { val intent = Intent(this, RusRadio::class.java); startActivity(intent) }
                R.id.spain -> { val intent = Intent(this, EspRadio::class.java); startActivity(intent) }
            }
        }
    }



    override  fun onCreateOptionsMenu(menu : Menu): Boolean  {
        val visit: String = getString(R.string.visit)
        val com: String = getString(R.string.com)
        menu.add(visit)
        menu.add(com)
       return super.onCreateOptionsMenu(menu)
   }

    override fun onOptionsItemSelected( item : MenuItem) : Boolean{
        val title: String = item.getTitle().toString()
        if(title == "Visitame"  || title == "Сайт")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://suzdalenko.com/")))
        else startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.suzdalenko.radio")))
        return super.onOptionsItemSelected(item)
    }
}
