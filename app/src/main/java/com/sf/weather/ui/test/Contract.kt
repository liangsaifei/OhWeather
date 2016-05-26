package com.sf.weather.ui.test

import com.sf.weather.data.dto.CityInfoVo
import com.sf.weather.data.dto.InstantWeatherVo
import com.sf.weather.data.service.WeatherService

interface Contract {
    interface View {
    }

    interface MyPresenter{
        fun getCityInfo():CityInfoVo
        fun getInstantWeather():InstantWeatherVo

    }
}