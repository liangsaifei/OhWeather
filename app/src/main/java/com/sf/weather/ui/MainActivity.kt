package com.sf.weather.ui

import android.os.Bundle
import cn.nekocode.kotgo.component.ui.FragmentActivity
import com.sf.weather.ui.main.MainFragment

class MainActivity: FragmentActivity() {
    override fun afterOnCreate(savedInstanceState: Bundle?) {
        super.afterOnCreate(savedInstanceState)
        MainFragment.push(this)
    }
}
