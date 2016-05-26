package com.sf.weather.ui.test

import android.os.Bundle
import cn.nekocode.kotgo.component.rx.RxBus
import cn.nekocode.kotgo.component.rx.bindLifecycle
import cn.nekocode.kotgo.component.rx.onUI
import cn.nekocode.kotgo.component.ui.BasePresenter
import com.sf.weather.data.dto.CityInfoVo
import com.sf.weather.data.dto.InstantWeatherVo
import com.sf.weather.data.model.WeatherModel
import com.sf.weather.data.service.WeatherService
import com.sf.weather.event.LoadFinishedEvent

/**
 * Created by Administrator on 2016/5/26 0026.
 */
class TestPresenter : BasePresenter(), Contract.MyPresenter {
    override fun getInstantWeather(): InstantWeatherVo = inWeather!!

    override fun getCityInfo(): CityInfoVo = cityi!!


    var inWeather: InstantWeatherVo? = null
    var cityi: CityInfoVo ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WeatherModel.getCityInfo("北京").onUI().bindLifecycle(this)
//                .subscribe {
//                    cityi = it
//
//                    RxBus.send(LoadFinishedEvent())
//
//                }

        WeatherModel.getInstantWeather("北京").onUI().bindLifecycle(this)
                .subscribe {

                    inWeather = it
                    RxBus.send(LoadFinishedEvent())

                }

    }

}