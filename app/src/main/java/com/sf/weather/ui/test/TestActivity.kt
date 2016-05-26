package com.sf.weather.ui.test

import android.os.Bundle
import cn.nekocode.kotgo.component.ui.FragmentActivity
import com.sf.weather.ui.test.TestFragment

/**
 * Created by Administrator on 2016/5/26 0026.
 */
class TestActivity : FragmentActivity() {
    override fun afterOnCreate(savedInstanceState: Bundle?) {
        super.afterOnCreate(savedInstanceState)
        TestFragment.push(this)


    }
}