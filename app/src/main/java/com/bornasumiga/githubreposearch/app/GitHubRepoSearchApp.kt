package com.bornasumiga.githubreposearch.app

import android.app.Application
import com.bornasumiga.githubreposearch.RepoList.di.repoListModule
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
                    networkingModule,
                    repoListModule
                )
            )
        }
    }
}