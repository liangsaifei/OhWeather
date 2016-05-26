package com.sf.weather.data.service

import com.sf.weather.data.DataLayer
import com.sf.weather.data.dto.CityInfoVo
import com.sf.weather.data.dto.CityListVo
import com.sf.weather.data.dto.InstantWeatherVo
import com.sf.weather.data.dto.WeeklyWeatherVo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Administrator on 2016/5/26 0026.
 */
class WeatherService {
    companion object {
        // Host
        const val API_HOST_URL: String = " http://apis.baidu.com/apistore/weatherservice/"

        val api: APIs

        init {
            val restAdapter = Retrofit.Builder()
                    .baseUrl(API_HOST_URL)
                    .addConverterFactory(GsonConverterFactory.create(DataLayer.gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(DataLayer.okHttpClient)
                    .build()

            api = restAdapter.create(APIs::class.java)
        }
    }


    interface APIs {
//        @GET("{count}/{pageNum}")
//        fun getMeizi(@Path("count") count: Int, @Path("pageNum") pageNum: Int): Observable<ResponseWrapper<Meizi>>


        @GET("weather")
        fun getInstantWeather(@Query("cityname") cityName: String): Observable<InstantWeatherVo>


        /**获取包含cityname的城市列表*/
        @GET("citylist")
        fun getCityList(@Query("cityname") cityName: String): Observable<CityListVo>

        @GET("recentweathers")
        fun getWeeklyWeather(@Query("cityname") cityName: String, @Query("cityid") cityid: String):
                Observable<WeeklyWeatherVo>

        @GET("cityinfo")
        fun getCityInfo(@Query("cityname") cityName: String): Observable<CityInfoVo>

    }


}