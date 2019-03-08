package com.xhd.mvp.presenter

import android.content.Context
import android.text.TextUtils
import com.xhd.mvp.model.NetworkStatusModel
import com.xhd.mvp.view.NetworkStatusView
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * created by huadong.xu on 19/3/8
 */
class NetworkStatusPresenter : BasePresenter<NetworkStatusView, NetworkStatusModel>() {

    //调用model请求数据 view callback
    fun getNetworkStatus(context: Context) {
        addSubscription(Observable.create(Observable.OnSubscribe<String> {
            var status = model!!.getNetworkStatus(context)
            it.onNext(status)
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            if (!TextUtils.isEmpty(it)) {
                view!!.showNetworkStatus(it)
            }
        })
    }
}
