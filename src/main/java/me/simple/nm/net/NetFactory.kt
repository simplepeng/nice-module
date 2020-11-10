package me.simple.nm.net

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetFactory {
    companion object {

        fun newOkHttpBuilder(timeOut: Long = 30) = OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())

        fun newRetrofitBuilder() = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
    }
}