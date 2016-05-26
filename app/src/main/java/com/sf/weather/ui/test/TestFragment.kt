package com.sf.weather.ui.test

import android.os.Bundle
import android.view.View
import cn.nekocode.kotgo.component.rx.bus
import cn.nekocode.kotgo.component.ui.BaseFragment
import cn.nekocode.kotgo.component.ui.FragmentActivity
import com.sf.weather.R
import com.sf.weather.event.LoadFinishedEvent
import org.jetbrains.anko.toast

/**
 * Created by Administrator on 2016/5/26 0026.
 */
class TestFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_page2

    lateinit  var testPresenter:Contract.MyPresenter

    companion object {
        const val TAG = "TestFragment"

        fun push(fragmentActivity: FragmentActivity) {
            fragmentActivity.push(TAG, TestFragment::class.java)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testPresenter = bindPresenter<TestPresenter>()
        bus {
            subscribe(LoadFinishedEvent::class.java){
                toast(testPresenter.getInstantWeather().toString())
            }

        }


    }

}