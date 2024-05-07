package com.zk.demozk.module.flutterModule

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity

/**
 * @author zhaokang
 * @date :2024/5/7
 * @description:
 */
class FlutterDemoActivity : FlutterActivity() {
    companion object {
        const val PARAMS = "params"
    }

    var params: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        params = intent.getStringExtra(PARAMS)
    }

    override fun getInitialRoute(): String {
        if (params == null) {
            super.getInitialRoute()
        } else {
            return params as String
        }
        return ""
    }
}