package com.xhd.mvp.presenter

import com.xhd.mvp.model.BaseModel
import com.xhd.mvp.view.BaseView
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * created by huadong.xu on 19/3/8
 * 调用model 请求处理数据
 */
open class BasePresenter<V : BaseView, M : BaseModel> {

    //presenter内统一管理数据请求，UI destroy时  可以取消所有请求防止超时导致内存泄漏问题
    var compositeSubscription: CompositeSubscription? = null

    var view: V? = null
        private set
    var model: M? = null
        private set

    fun onViewCreate(view: Any?) {
        this.view = view as V
        if (this.compositeSubscription == null) {
            this.compositeSubscription = CompositeSubscription()
        }
    }

    fun onModelCreate(model: Any?) {
        this.model = model as M
    }

    fun addSubscription(s: Subscription) {
        this.compositeSubscription?.add(s)
    }

    fun destory() {
        view = null
        model = null
        this.compositeSubscription?.unsubscribe()
        this.compositeSubscription = null
    }
}
