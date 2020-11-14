package com.bornasumiga.githubreposearch.RepoList.di

import com.bornasumiga.githubreposearch.RepoList.interactor.RepoListInteractor
import com.bornasumiga.githubreposearch.RepoList.rest_interface.RepoListInterface
import com.bornasumiga.githubreposearch.app.common.REPO_LIST_RETROFIT
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val repoListModule = module {
    factory { provideRepoListInterface(get(named(REPO_LIST_RETROFIT))) }
    factory { RepoListInteractor(get()) }
    //TODO: VIEWMODEL
}

private fun provideRepoListInterface(retrofit: Retrofit) = retrofit.create(RepoListInterface::class.java)