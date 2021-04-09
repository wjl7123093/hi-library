package org.devio.hi.library.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.devio.hi.library.app.R
import org.devio.hi.library.hilibrary.log.*

class HiLogDemoActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_log_demo)
        viewPrinter = HiViewPrinter(this)
        findViewById<View>(R.id.btn_print_log).setOnClickListener {
            printLog()
        }
        viewPrinter!!.viewProvider.showFloatingView()
    }

    private fun printLog() {
        // 添加日志可视化打印器
        HiLogManager.getInstance().addPrinter(viewPrinter)
        // 自定义Log配置
        HiLog.log(object : HiLogConfig() {
            override fun includeThread(): Boolean {
                return true    // true 打印线程信息
            }

            override fun stackTraceDepth(): Int {
                return 0    // 0 不打印堆栈信息
            }
        }, HiLogType.E, "------", "5566")
        HiLog.a("9900")
    }
}
