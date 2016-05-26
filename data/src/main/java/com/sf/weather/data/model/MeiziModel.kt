package com.sf.weather.data.model

import com.sf.weather.data.dto.Meizi
import com.sf.weather.data.exception.ServiceException
import com.sf.weather.data.service.GankService
import com.orhanobut.hawk.Hawk
import rx.Observable
import rx.schedulers.Schedulers

object MeiziModel {

    // Bussines Logic
    fun getMeizis(count: Int, pageNum: Int): Observable<List<Meizi>> =
            GankService.api.getMeizi(count, pageNum)
                    .subscribeOn(Schedulers.io())
                    .map {
                        Hawk.put("meizis", it.results)
                        it.results
                    }
                    .onErrorResumeNext {
                        // Fetech data from local cache
                        val meiziList: List<Meizi> = Hawk.get("meizis")
                                ?: throw ServiceException(it.message)
                        Observable.just(meiziList)
                    }

}