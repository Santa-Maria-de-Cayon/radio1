package com.suzdalenko.radio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.ScrollView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_esp_radio.*
import kotlinx.android.synthetic.main.activity_esp_radio.player_view



class EspRadio : AppCompatActivity()  , View.OnClickListener {
    lateinit var  player: SimpleExoPlayer
    lateinit var mAdViewRus : AdView
    lateinit var rus_scrol : ScrollView
    lateinit var layoutParams : RelativeLayout.LayoutParams


    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.dial ->       openBrouser("http://suzdalenko.com?+cadena-dial")
                R.id.los40 ->      openBrouser("http://suzdalenko.com?+los-40")
                R.id.los40clas ->  openBrouser("http://suzdalenko.com?+los-40-classic")
                R.id.cien ->       openBrouser("http://suzdalenko.com?+cadena-100")
                R.id.rock ->       openBrouser("http://suzdalenko.com?+rock")
                R.id.loca ->       openBrouser("http://suzdalenko.com?+loca-fm")
                R.id.rac1 ->       openBrouser("http://suzdalenko.com?+rac1")
                R.id.onda ->       openBrouser("http://suzdalenko.com?+onda-cero")
                R.id.ibiza ->      openBrouser("http://suzdalenko.com?+ibiza")
                R.id.rne ->        openBrouser("http://suzdalenko.com?+rne")
                R.id.inter ->      openBrouser("http://suzdalenko.com?+inter-economia")
                R.id.ser ->        openBrouser("http://suzdalenko.com?+ser")
                R.id.ib ->         openBrouser("http://suzdalenko.com?+ibiza-sonica")
                R.id.vinilo ->     openBrouser("http://suzdalenko.com?+vinilo")
                R.id.cope ->       openBrouser("http://suzdalenko.com?+cope")
                R.id.max ->        openBrouser("http://suzdalenko.com?+maxima")
                R.id.hit ->        openBrouser("http://suzdalenko.com?+hit")
                R.id.kiss ->       openBrouser("http://suzdalenko.com?+kiss")
                R.id.gay ->        openBrouser("http://suzdalenko.com?+gay")
                R.id.fresca ->     openBrouser("http://suzdalenko.com?+la-fresca")
                R.id.holi ->       openBrouser("http://suzdalenko.com?+holidaygym")
                R.id.xxx ->        openBrouser("http://suzdalenko.com?+xxx-rock")
                R.id.radiole ->    openBrouser("http://suzdalenko.com?+radiole")
                R.id.localatino -> openBrouser("http://suzdalenko.com?+loca-latino")

                R.id._dial ->       playExoPlayer("https://17873.live.streamtheworld.com/CADENADIAL_SC")
                R.id._los40 ->      playExoPlayer("https://20403.live.streamtheworld.com/LOS40_SC")
                R.id._los40clas ->  playExoPlayer("https://20863.live.streamtheworld.com/LOS40_CLASSIC_SC")
                R.id._cien ->       playExoPlayer("https://cadena100-cope-rrcast.flumotion.com/cope/cadena100-low.mp3")
                R.id._rock ->       playExoPlayer("https://rockfm-cope-rrcast.flumotion.com/cope/rockfm-low.mp3")
                R.id._loca ->       playExoPlayer("http://audio-online.net:2300/live")
                R.id._rac1 ->       playExoPlayer("https://streaming.rac1.cat/")
                R.id._onda ->       playExoPlayer("https://icecast-streaming.nice264.com/ondacero")
                R.id._ibiza ->      playExoPlayer("http://ibizaglobalradio.streaming-pro.com:8024/stream/1/")
                R.id._rne ->        playExoPlayer("http://rne.rtveradio.cires21.com/rne.mp3")
                R.id._inter ->      playExoPlayer("http://212.85.46.144/siliconorg")
                R.id._ser ->        playExoPlayer("https://19983.live.streamtheworld.com/CADENASER_SC")
                R.id._ib ->         playExoPlayer("http://s1.sonicabroadcast.com:7005/stream/1/")
                R.id._vinilo ->     playExoPlayer("http://server9.emitironline.com:10923/;")
                R.id._cope ->       playExoPlayer("https://net1-cope-rrcast.flumotion.com/cope/net1-low.mp3")
                R.id._max ->        playExoPlayer("https://20073.live.streamtheworld.com/MAXIMAFM_SC")
                R.id._hit ->        playExoPlayer("https://hitfm.kissfmradio.cires21.com/hitfm.mp3")
                R.id._kiss ->       playExoPlayer("http://kissfm.kissfmradio.cires21.com/kissfm.mp3")
                R.id._gay ->        playExoPlayer("http://icepool.silvacast.com/GAYFM.mp3")
                R.id._fresca ->     playExoPlayer("http://stream.produccionesdale.com:8899/altacalidad")
                R.id._holi ->       playExoPlayer("http://holidaygym.emitironline.com/")
                R.id._xxx ->        playExoPlayer("http://sc15.shoutcaststreaming.us:8140/;4537697477933063stream.nsv")
                R.id._radiole ->    playExoPlayer("http://20723.live.streamtheworld.com/RADIOLE.mp3")
                R.id._localatino -> playExoPlayer("http://audio-online.net:8012/live")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esp_radio)



        rus_scrol = findViewById(R.id.es_scrol)
        MobileAds.initialize(this) {}

        mAdViewRus = findViewById(R.id.mAdViewRus)
        val adRequest = AdRequest.Builder().build()
        mAdViewRus.loadAd(adRequest)
        Log.d("tag", "start start")
        layoutParams = rus_scrol.getLayoutParams() as RelativeLayout.LayoutParams
        mAdViewRus.adListener = object: AdListener() {
            override fun onAdLoaded() {
                layoutParams.setMargins(0, 75, 0, 190);
                rus_scrol.setLayoutParams(layoutParams)
            }
        }










        player  = ExoPlayerFactory.newSimpleInstance(this)
        player_view.setPlayer(player)
        player.setPlayWhenReady(true);
        player_view.setControllerHideOnTouch(false)


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

        _dial.setOnClickListener(this)
        _los40.setOnClickListener(this)
        _los40clas.setOnClickListener(this)
        _cien.setOnClickListener(this)
        _rock.setOnClickListener(this)
        _loca.setOnClickListener(this)
        _rac1.setOnClickListener(this)
        _onda.setOnClickListener(this)
        _ibiza.setOnClickListener(this)
        _rne.setOnClickListener(this)
        _inter.setOnClickListener(this)
        _ser.setOnClickListener(this)
        _ib.setOnClickListener(this)
        _vinilo.setOnClickListener(this)
        _cope.setOnClickListener(this)
        _max.setOnClickListener(this)
        _hit.setOnClickListener(this)
        _kiss.setOnClickListener(this)
        _gay.setOnClickListener(this)
        _fresca.setOnClickListener(this)
        _holi.setOnClickListener(this)
        _xxx.setOnClickListener(this)
        _radiole.setOnClickListener(this)
        _localatino.setOnClickListener(this)





    }

    private fun playExoPlayer(s: String) {
        val contentMediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(
            DefaultDataSourceFactory(this, "Mozilla")
        ).createMediaSource(Uri.parse(s))
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
        menu.add(visit)
        menu.add(com)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected( item : MenuItem) : Boolean{
        val title: String = item.getTitle().toString()
        if(title == "Visitame" || title == "Сайт")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://suzdalenko.com/")))
        else startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.suzdalenko.radio")))
        return super.onOptionsItemSelected(item)
    }
}
