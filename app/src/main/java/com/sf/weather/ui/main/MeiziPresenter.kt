package com.sf.weather.ui.main

import android.app.Activity
import android.os.Bundle
import cn.nekocode.kotgo.component.rx.RxBus
import cn.nekocode.kotgo.component.rx.bindLifecycle
import cn.nekocode.kotgo.component.rx.onUI
import cn.nekocode.kotgo.component.ui.BasePresenter
import com.sf.weather.data.dto.Meizi
import com.sf.weather.data.model.MeiziModel
import com.sf.weather.event.LoadFinishedEvent
import com.sf.weather.ui.page2.Page2Fragment
import java.util.*

class MeiziPresenter(): BasePresenter(), Contract.MainPresenter {
    var view: Contract.View? = null
    val meiziList = ArrayList<Meizi>()
    val meiziListadapter = MeiziListAdapter(meiziList)

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        view = getParent() as Contract.View
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MeiziModel.getMeizis(50, 1).onUI().bindLifecycle(this).subscribe {
            meiziList.addAll(it)
            meiziListadapter.notifyDataSetChanged()

            RxBus.send(LoadFinishedEvent())
        }

        meiziListadapter.onMeiziItemClickListener = {
            Page2Fragment.push(fragAct!!, it)
        }
    }

    override fun getAdapter(): MeiziListAdapter = meiziListadapter
}