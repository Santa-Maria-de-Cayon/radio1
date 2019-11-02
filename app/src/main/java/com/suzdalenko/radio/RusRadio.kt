package com.suzdalenko.radio

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_rus_radio.*

class RusRadio : AppCompatActivity()  , View.OnClickListener {
    lateinit var mAdViewRus : AdView
    lateinit var  player:SimpleExoPlayer
    lateinit var rus_scrol : ScrollView
    lateinit var layoutParams : RelativeLayout.LayoutParams
    var heitLinAds = 0
    var heigthPlayer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rus_radio)



        rus_scrol = findViewById(R.id.rus_scrol)
        MobileAds.initialize(this) {}

        mAdViewRus = findViewById(R.id.mAdViewRus)
        val adRequest = AdRequest.Builder().build()
        mAdViewRus.loadAd(adRequest)
        Log.d("tag", "start start")
        layoutParams = rus_scrol.getLayoutParams() as RelativeLayout.LayoutParams

        mAdViewRus.adListener = object: AdListener() {
            override fun onAdLoaded() {
                rus_scrol.post{
                    heigthPlayer = player_view.height + 3
                    heitLinAds = mAdViewRus.height + 3
                    layoutParams.setMargins(0, heigthPlayer, 0, heitLinAds);
                    rus_scrol.setLayoutParams(layoutParams)
                }

            }
        }












        player  = ExoPlayerFactory.newSimpleInstance(this)
        player_view.setPlayer(player)
        player.setPlayWhenReady(true);
        player_view.setControllerHideOnTouch(false)


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

        rossii.setOnClickListener(this)
        record.setOnClickListener(this)
        newradio.setOnClickListener(this)
        marusya.setOnClickListener(this)
        evropa.setOnClickListener(this)
        energy.setOnClickListener(this)

        _rus_radio96.setOnClickListener(this)
        _svoboda.setOnClickListener(this)
        _rus_radio128.setOnClickListener(this)
        _drug_astraj32.setOnClickListener(this)
        _drug_astraj128.setOnClickListener(this)
        _shanson.setOnClickListener(this)
        _ejo.setOnClickListener(this)
        _di.setOnClickListener(this)
        _yomor.setOnClickListener(this)
        _r90.setOnClickListener(this)
        _vesti.setOnClickListener(this)
        _mayak.setOnClickListener(this)
        _komsomol.setOnClickListener(this)
        _ser48.setOnClickListener(this)
        _ser128.setOnClickListener(this)

        _rossii.setOnClickListener(this)
        _record.setOnClickListener(this)
        _newradio.setOnClickListener(this)
        _marusya.setOnClickListener(this)
        _evropa.setOnClickListener(this)
        _energy.setOnClickListener(this)




    }



    override fun onClick(v: View?) {
        if (v != null) {
            if(v is TextView){
                setColor()
                v.setTextColor(Color.parseColor("#ffffff"))
            }
            when(v.id){
                R.id.rus_radio96    -> openBrouser("http://suzdalenko.com?+russkoe-radio96")
                R.id.svoboda        -> openBrouser("http://suzdalenko.com?+svoboda")
                R.id.rus_radio128   -> openBrouser("http://suzdalenko.com?+russkoe-radio128")
                R.id.drug_astraj32  -> openBrouser("http://suzdalenko.com?+drugaya-astrajan32")
                R.id.drug_astraj128 -> openBrouser("http://suzdalenko.com?+drugaya-astrajan128")
                R.id.shanson        -> openBrouser("http://suzdalenko.com?+shanson")
                R.id.ejo            -> openBrouser("http://suzdalenko.com?+ejo-moskvi")
                R.id.di             -> openBrouser("http://suzdalenko.com?+di-fm")
                R.id.yomor          -> openBrouser("http://suzdalenko.com?+yumor-fm")
                R.id.r90            -> openBrouser("http://suzdalenko.com?+90")
                R.id.vesti          -> openBrouser("http://suzdalenko.com?+vesti-fm")
                R.id.mayak          -> openBrouser("http://suzdalenko.com?+mayak")
                R.id.komsomol       -> openBrouser("http://suzdalenko.com?+komsomol")
                R.id.ser48          -> openBrouser("http://suzdalenko.com?+serebryaniy-dozd-48")
                R.id.ser128         -> openBrouser("http://suzdalenko.com?+serebryaniy-dozd-128")
                R.id.rossii         -> openBrouser("http://suzdalenko.com?+radio-rossii")
                R.id.record         -> openBrouser("http://suzdalenko.com?+record")
                R.id.newradio       -> openBrouser("http://suzdalenko.com?+newradio")
                R.id.marusya        -> openBrouser("http://suzdalenko.com?+marusya")
                R.id.evropa         -> openBrouser("http://suzdalenko.com?+evropa")
                R.id.energy         -> openBrouser("http://suzdalenko.com?+energy")

                R.id._rus_radio96    -> playExoPlayer("https://rusradio.hostingradio.ru/rusradio96.aacp")
                R.id._svoboda        -> playExoPlayer("https://ample-05.radiojar.com/hcrb063nn3quv")
                R.id._rus_radio128   -> playExoPlayer("https://rusradio.hostingradio.ru/rusradio128.mp3")
                R.id._drug_astraj32  -> playExoPlayer("http://89.179.72.53:8070/mini")
                R.id._drug_astraj128 -> playExoPlayer("http://89.179.72.53:8070/live")
                R.id._shanson        -> playExoPlayer("http://chanson.hostingradio.ru:8041/chanson128.mp3")
                R.id._ejo            -> playExoPlayer("http://ice912.echo.msk.ru:9120/stream")
                R.id._di             -> playExoPlayer("https://dfm.hostingradio.ru/dfm96.aacp")
                R.id._yomor          -> playExoPlayer("http://ic3.101.ru:8000/v5_1")
                R.id._r90            -> playExoPlayer("http://air.radiorecord.ru:8102/sd90_320")
                R.id._vesti          -> playExoPlayer("http://icecast.vgtrk.cdnvideo.ru/vestifm_mp3_192kbps")
                R.id._mayak          -> playExoPlayer("http://icecast.vgtrk.cdnvideo.ru/mayakfm_mp3_192kbps")
                R.id._komsomol       -> playExoPlayer("https://kpradio.hostingradio.ru:8000/russia.radiokp128.mp3")
                R.id._ser48          -> playExoPlayer("http://213.59.4.27:8000/stream48.mp3")
                R.id._ser128         -> playExoPlayer("http://213.59.4.27:8000/silver128.mp3")
                R.id._rossii         -> playExoPlayer("http://icecast.vgtrk.cdnvideo.ru/rrzonam_mp3_192kbps")
                R.id._record         -> playExoPlayer("http://air.radiorecord.ru:805/rr_320")
                R.id._newradio       -> playExoPlayer("http://icecast.newradio.cdnvideo.ru/newradio3")
                R.id._marusya        -> playExoPlayer("http://radio-holding.ru:9000/marusya_default")
                R.id._evropa         -> playExoPlayer("http://europaplus.hostingradio.ru:8014/europaplus320.mp3")
                R.id._energy         -> playExoPlayer("http://ic3.101.ru:8000/s20")
            }
        }
    }

    private fun playExoPlayer(s: String) {
        val contentMediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(DefaultDataSourceFactory(this, "Mozilla")).createMediaSource(Uri.parse(s))
        player.prepare(contentMediaSource)
    }


    private fun openBrouser(s: String) {
        val uris:Uri = Uri.parse(s);val intents = Intent(Intent.ACTION_VIEW, uris);startActivity(intents);
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override  fun onCreateOptionsMenu(menu : Menu): Boolean  {
        val visit: String = getString(R.string.visit)
        val com: String = getString(R.string.com)
        val compart : String = getString(R.string.compart)
        menu.add(visit)
        menu.add(com)
        menu.add(compart)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected( item : MenuItem) : Boolean{
        val title: String = item.getTitle().toString()
        if(title == "Compartir" || title == "Поделиться"){
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Слушай радио. Это главное        https://play.google.com/store/apps/details?id=com.suzdalenko.radio");
            startActivity(Intent.createChooser(shareIntent, "Radio"))
        }
        else if(title == "Visitame" || title == "Сайт")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://suzdalenko.com/")))
        else startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.suzdalenko.radio")))
        return super.onOptionsItemSelected(item)
    }

    fun setColor(){
       _rus_radio96   .setTextColor(Color.parseColor("#000000"))
       _svoboda       .setTextColor(Color.parseColor("#000000"))
       _rus_radio128  .setTextColor(Color.parseColor("#000000"))
       _drug_astraj32 .setTextColor(Color.parseColor("#000000"))
       _drug_astraj128.setTextColor(Color.parseColor("#000000"))
       _shanson       .setTextColor(Color.parseColor("#000000"))
       _ejo           .setTextColor(Color.parseColor("#000000"))
       _di            .setTextColor(Color.parseColor("#000000"))
       _yomor         .setTextColor(Color.parseColor("#000000"))
       _r90           .setTextColor(Color.parseColor("#000000"))
       _vesti         .setTextColor(Color.parseColor("#000000"))
       _mayak         .setTextColor(Color.parseColor("#000000"))
       _komsomol      .setTextColor(Color.parseColor("#000000"))
       _ser48         .setTextColor(Color.parseColor("#000000"))
       _ser128        .setTextColor(Color.parseColor("#000000"))
       _rossii        .setTextColor(Color.parseColor("#000000"))
       _record        .setTextColor(Color.parseColor("#000000"))
       _newradio      .setTextColor(Color.parseColor("#000000"))
       _marusya       .setTextColor(Color.parseColor("#000000"))
       _evropa        .setTextColor(Color.parseColor("#000000"))
       _energy        .setTextColor(Color.parseColor("#000000"))

    }
}





































