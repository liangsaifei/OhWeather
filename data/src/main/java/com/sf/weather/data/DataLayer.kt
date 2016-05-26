package com.sf.weather.data

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.HawkBuilder
import com.orhanobut.hawk.LogLevel
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

object DataLayer {
    // OkHttp Config
    const val RESPONSE_CACHE_FILE: String = "reponse_cache"
    const val RESPONSE_CACHE_SIZE = 10 * 1024 * 1024L
    const val HTTP_CONNECT_TIMEOUT = 10L
    const val HTTP_READ_TIMEOUT = 30L
    const val HTTP_WRITE_TIMEOUT = 10L

    lateinit var app: Application
    lateinit var okHttpClient: OkHttpClient
    val gson: Gson = GsonBuilder().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create()

    fun hook(app: Application) {
        DataLayer.app = app

        Hawk.init(app)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSqliteStorage(app))
                .setLogLevel(LogLevel.FULL)
                .build()

        val cacheDir = File(app.cacheDir, RESPONSE_CACHE_FILE)
        okHttpClient = OkHttpClient.Builder()
                .cache(Cache(cacheDir, RESPONSE_CACHE_SIZE))
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor()).
                addNetworkInterceptor(headerInterceptor)
                .build()

        Stetho.initializeWithDefaults(app)
    }


    val headerInterceptor = okhttp3.Interceptor {
        chain ->
        val request = chain.request().newBuilder().addHeader("apikey", "547adbfc6aa9d99b808862940108ff00").build()
        chain.proceed(request);
    }
}