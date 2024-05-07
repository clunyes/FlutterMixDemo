package com.zk.demozk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zk.demozk.databinding.ActivityMainBinding
import com.zk.demozk.module.flutterModule.FlutterDemoActivity
import com.zk.demozk.module.pathAnim.PathAnimActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClick()
    }

    private fun initClick() {
        binding.tvPathAnim.setOnClickListener {
            val intent = Intent(this, PathAnimActivity::class.java)
            startActivity(intent)
        }
        binding.tvFlutter.setOnClickListener{
            val intent = Intent(this, FlutterDemoActivity::class.java)
            intent.putExtra(FlutterDemoActivity.PARAMS, "params")
            startActivity(intent)
        }
    }
}