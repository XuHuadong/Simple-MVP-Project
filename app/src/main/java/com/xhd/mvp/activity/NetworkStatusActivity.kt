package com.xhd.mvp.activity

import android.os.Bundle
import android.widget.TextView
import com.xhd.mvp.R
import com.xhd.mvp.model.NetworkStatusModel
import com.xhd.mvp.presenter.NetworkStatusPresenter
import com.xhd.mvp.view.NetworkStatusView

class NetworkStatusActivity : BaseMVPActivity<NetworkStatusPresenter, NetworkStatusModel, NetworkStatusView>(), NetworkStatusView {

    private var tvStatus: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_status)

        tvStatus = findViewById(R.id.status)

        presenter?.getNetworkStatus(this)
    }

    override fun initPresenter(): NetworkStatusPresenter {
        return NetworkStatusPresenter()
    }

    override fun initView(): NetworkStatusView {
        return this
    }

    override fun initModel(): NetworkStatusModel {
        return NetworkStatusModel()
    }

    override fun showNetworkStatus(status: String) {
        tvStatus!!.text = status
    }

    override fun showToast() {

    }

    override fun showLoading() {

    }

    override fun disLoading() {

    }
}
