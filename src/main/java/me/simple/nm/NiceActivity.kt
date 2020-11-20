package me.simple.nm

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class NiceActivity : AppCompatActivity() {

    protected open lateinit var mContext: Activity

    abstract fun setLayoutRes(): Int
    abstract fun initView()
    abstract fun initData()
    abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        onBeforeCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        mContext = this
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentView(setLayoutRes())

        onAfterCreate(savedInstanceState)

        initView()
        initData()
        initListener()
    }

    protected open fun onBeforeCreate(savedInstanceState: Bundle?) {

    }

    protected open fun onAfterCreate(savedInstanceState: Bundle?) {

    }


}