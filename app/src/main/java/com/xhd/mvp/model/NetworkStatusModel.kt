package com.xhd.mvp.model

import android.content.Context
import android.net.ConnectivityManager

/**
 * created by huadong.xu on 19/3/8
 */
class NetworkStatusModel : BaseModel {

    //处理数据
    fun getNetworkStatus(context: Context): String {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return if (info != null) {
            info.typeName
        } else "OTHER"
    }
}
