package com.xhd.mvp.activity

import android.os.Bundle
import com.xhd.mvp.model.BaseModel
import com.xhd.mvp.presenter.BasePresenter
import com.xhd.mvp.view.BaseMVPInit
import com.xhd.mvp.view.BaseView

/**
 * created by huadong.xu on 19/3/8
 */
abstract class BaseMVPActivity<P : BasePresenter<*, *>, M : BaseModel, V : BaseView> : BaseActivity(), BaseMVPInit<P, M, V> {

    var presenter: P? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = initPresenter()
        if (presenter != null) {
            presenter!!.onModelCreate(initModel())
            presenter!!.onViewCreate(initView())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter!!.destory()
        }
    }
}
