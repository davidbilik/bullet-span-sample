package cz.davidbilik.bulletsample

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity displaying dummy fix for not present bullets on Api 21
 */
class Api21Fix1stActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        @Suppress("DEPRECATION")
        txt_html.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html, null,
                Html.TagHandler { opening, tag, output, xmlReader ->
                    if (tag == "ul" && !opening) output.append("\n")
                    if (tag == "li" && opening) output.append("\n\t• ")
                })
        }
    }
}