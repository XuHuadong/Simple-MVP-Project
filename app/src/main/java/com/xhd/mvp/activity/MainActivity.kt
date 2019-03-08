package com.xhd.mvp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.xhd.mvp.R

/**
 * created by huadong.xu on 19/3/8
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toNetworkStatus(view: View) {
        startActivity(Intent(this@MainActivity, NetworkStatusActivity::class.java))
    }
}
