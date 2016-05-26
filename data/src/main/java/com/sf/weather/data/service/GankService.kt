package com.sf.weather.data.service

import com.sf.weather.data.DataLayer
import com.sf.weather.data.dto.Meizi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


class GankService {
    companion object {
        // Host
        const val API_HOST_URL: String = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/"

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

    data class ResponseWrapper<T>(val error: Boolean, val results: List<T>)

    interface APIs {
        @GET("{count}/{pageNum}")
        fun getMeizi(@Path("count") count: Int, @Path("pageNum") pageNum: Int): Observable<ResponseWrapper<Meizi>>
    }
}
