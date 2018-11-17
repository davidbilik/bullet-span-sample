package cz.davidbilik.bulletsample

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.util.TypedValue
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity displaying solution for incorrectly positioned bullets with non-standard TextView line height.
 */
class Api25FixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        @Suppress("DEPRECATION")
        val htmlSpannable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html, null, LiTagHandler())
        }

        val spannableBuilder = SpannableStringBuilder(htmlSpannable)
        val bulletSpans = spannableBuilder.getSpans(0, spannableBuilder.length, BulletSpan::class.java)
        bulletSpans.forEach {
            val start = spannableBuilder.getSpanStart(it)
            val end = spannableBuilder.getSpanEnd(it)
            spannableBuilder.removeSpan(it)
            spannableBuilder.setSpan(
                ImprovedBulletSpan(bulletRadius = dip(3), gapWidth = dip(8)),
                start,
                end,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
        }
        txt_html.text = spannableBuilder
    }

    private fun dip(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()
    }
}