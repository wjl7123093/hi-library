package org.devio.hi.library.app.demo.tab

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hi_tab_bottom_demo.*
import org.devio.hi.library.app.R
import org.devio.hi.library.hilibrary.util.HiDisplayUtil
import org.devio.hi.ui.tab.bottom.HiTabBottom
import org.devio.hi.ui.tab.bottom.HiTabBottomInfo
import org.devio.hi.ui.tab.bottom.HiTabBottomLayout

class HiTabBottomDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_tab_bottom_demo)
        initTabBottom()
    }

    private fun initTabBottom() {
        val hiTabBottomLayout:HiTabBottomLayout = findViewById(R.id.tab_bottom_layout)
        hiTabBottomLayout.setTabAlpha(0.85f)
        val bottomInfoList:MutableList<HiTabBottomInfo<*>> = ArrayList()
        // MutableList 可变列表（Kotlin 中独有）

        val infoHome = HiTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_home),
            null,
            "#ff656667",
            "#ffd44949"
        )

        val infoFavorite = HiTabBottomInfo(
            "收藏",
            "fonts/iconfont.ttf",
            getString(R.string.if_favorite),
            null,
            "#ff656667",
            "#ffd44949"
        )

//        val infoCategory = HiTabBottomInfo(
//            "分类",
//            "fonts/iconfont.ttf",
//            getString(R.string.if_category),
//            null,
//            "#ff656667",
//            "#ffd44949"
//        )
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.fire, null)
        val infoCategory = HiTabBottomInfo<String>(
            "分类",
            bitmap,
            bitmap
        )

        val infoRecommend = HiTabBottomInfo(
            "推荐",
            "fonts/iconfont.ttf",
            getString(R.string.if_recommend),
            null,
            "#ff656667",
            "#ffd44949"
        )

        val infoProfile = HiTabBottomInfo(
            "我的",
            "fonts/iconfont.ttf",
            getString(R.string.if_profile),
            null,
            "#ff656667",
            "#ffd44949"
        )
        bottomInfoList.add(infoHome)
        bottomInfoList.add(infoFavorite)
        bottomInfoList.add(infoCategory)
        bottomInfoList.add(infoRecommend)
        bottomInfoList.add(infoProfile)
        hiTabBottomLayout.inflateInfo(bottomInfoList)
        hiTabBottomLayout.addTabSelectedChangeListener { index, prevInfo, nextInfo ->
            Toast.makeText(this@HiTabBottomDemoActivity, nextInfo.name, Toast.LENGTH_LONG).show()
        }
        hiTabBottomLayout.defaultSelected(infoHome)
        // 改变某个 tab 高度
        var tabBottom = hiTabBottomLayout.findTab(bottomInfoList[2])    // 中间Tab
        tabBottom?.apply { resetHight(HiDisplayUtil.dp2px(66f, resources)) }
    }
}