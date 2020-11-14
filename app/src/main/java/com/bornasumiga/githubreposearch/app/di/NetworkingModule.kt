package com.bornasumiga.githubreposearch.di

import com.bornasumiga.githubreposearch.app.common.GITHUB_BASE_URL
import com.bornasumiga.githubreposearch.app.common.HTTP_CLIENT
import com.bornasumiga.githubreposearch.app.common.NEWS_RETROFIT
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkingModule = module {

    //CACHE
    val networkCacheInterceptor = Interceptor{
        val response = it.proceed(it.request())
        val cacheControl = CacheControl.Builder()
            .maxAge(2, TimeUnit.MINUTES)
            .build()
        response.newBuilder()
            .header("Cache-Control",cacheControl.toString())
            .build()
    }

    //OKHTTP
    single(named(HTTP_CLIENT)){
        val cacheSize = (10*1024*1024).toLong()
        val myCache = Cache(androidApplication().cacheDir,cacheSize)
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(networkCacheInterceptor)
            .cache(myCache)
            .build()
    }

    //RETROFIT
    single(named(NEWS_RETROFIT)){
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GITHUB_BASE_URL)
            .client(get(named(HTTP_CLIENT)))
            .build()
    }
}