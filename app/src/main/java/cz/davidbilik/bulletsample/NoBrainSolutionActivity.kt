package cz.davidbilik.bulletsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*

class NoBrainSolutionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_html.text = Html.fromHtml(html)
    }
}
