package cz.davidbilik.bulletsample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

/**
 * Activity containing dashboard to other activities
 */
class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        btn_straightforward.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, NoBrainSolutionActivity::class.java))
        }
        btn_api211stfix.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, Api21Fix1stActivity::class.java))
        }
        btn_api212ndfix.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, Api21Fix2ndActivity::class.java))
        }
        btn_api25fix.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, Api25FixActivity::class.java))
        }
    }
}