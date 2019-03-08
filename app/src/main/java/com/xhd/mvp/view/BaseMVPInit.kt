package com.xhd.mvp.view

import com.xhd.mvp.model.BaseModel
import com.xhd.mvp.presenter.BasePresenter

/**
 * created by huadong.xu on 19/3/8
 **/
interface BaseMVPInit<P : BasePresenter<*, *>, M : BaseModel, V : BaseView> {
    fun initPresenter(): P
    fun initModel(): Any?
    fun initView(): Any?
}