package com.sf.weather.data.model

import com.orhanobut.hawk.Hawk
import com.sf.weather.data.dto.CityInfoVo
import com.sf.weather.data.dto.CityListVo
import com.sf.weather.data.dto.InstantWeatherVo
import com.sf.weather.data.dto.WeeklyWeatherVo
import com.sf.weather.data.exception.ServiceException
import com.sf.weather.data.service.WeatherService
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2016/5/26 0026.
 */
object WeatherModel {


    fun getInstantWeather(cityName: String): Observable<InstantWeatherVo> =
            WeatherService.api.getInstantWeather(cityName)
                    .subscribeOn(Schedulers.io())
                    .map {
                        Hawk.put("instantWeather", it)
                        it
                    }
                    .onErrorResumeNext {
                        // Fetech data from local cache
                        val instantVo: InstantWeatherVo = Hawk.get("instantWeather")
                                ?: throw ServiceException(it.message)
                        Observable.just(instantVo)
                    }

    fun getCityList(cityName: String): Observable<CityListVo> =
            WeatherService.api.getCityList(cityName)
                    .subscribeOn(Schedulers.io())
                    .map {
                        Hawk.put("cityList", it)
                        it
                    }
                    .onErrorResumeNext {
                        // Fetech data from local cache
                        val instantVo: CityListVo = Hawk.get("cityList")
                                ?: throw ServiceException(it.message)
                        Observable.just(instantVo)
                    }


    fun getWeeklyWeather(cityName: String, cityid: String): Observable<WeeklyWeatherVo> =
            WeatherService.api.getWeeklyWeather(cityName, cityid)
                    .subscribeOn(Schedulers.io())
                    .map {
                        Hawk.put("weeklyWeather", it)
                        it
                    }
                    .onErrorResumeNext {
                        // Fetech data from local cache
                        val vo: WeeklyWeatherVo = Hawk.get("weeklyWeather")
                                ?: throw ServiceException(it.message)
                        Observable.just(vo)
                    }

    fun getCityInfo(cityName: String): Observable<CityInfoVo> =
            WeatherService.api.getCityInfo(cityName)
                    .subscribeOn(Schedulers.io())
                    .map {
                        Hawk.put("cityInfo", it)
                        it
                    }
                    .onErrorResumeNext {
                        // Fetech data from local cache
                        val vo: CityInfoVo = Hawk.get("cityInfo")
                                ?: throw ServiceException(it.message)
                        Observable.just(vo)
                    }


}