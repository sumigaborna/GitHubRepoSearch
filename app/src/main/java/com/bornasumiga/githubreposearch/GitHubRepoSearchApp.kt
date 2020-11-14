package com.bornasumiga.githubreposearch

import android.app.Application
import com.bornasumiga.githubreposearch.di.networkingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubRepoSearchApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GitHubRepoSearchApp)
            modules(
                listOf(
                    networkingModule
                )
            )
        }
    }
}