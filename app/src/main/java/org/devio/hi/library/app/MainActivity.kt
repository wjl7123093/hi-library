package org.devio.hi.library.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.devio.hi.library.app.demo.HiLogDemoActivity
import org.devio.hi.library.app.demo.tab.HiTabBottomDemoActivity
import org.devio.hi.library.hilibrary.log.HiLog
import org.devio.hi.ui.tab.bottom.HiTabBottom
import org.devio.hi.ui.tab.bottom.HiTabBottomInfo

/**
 * Kotlin 和 Java 混编，混合开发【主流开发方式】
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btnLog -> {
                startActivity(Intent(this, HiLogDemoActivity::class.java))
            }
            R.id.tv_tab_bottom -> {
                startActivity(Intent(this, HiTabBottomDemoActivity::class.java))
            }
        }
    }
}
