package com.bornasumiga.githubreposearch.repoList.di

import com.bornasumiga.githubreposearch.repoList.interactor.RepoListInteractor
import com.bornasumiga.githubreposearch.repoList.rest_interface.RepoListInterface
import com.bornasumiga.githubreposearch.repoList.view_model.RepoListViewModel
import com.bornasumiga.githubreposearch.app.common.REPO_LIST_RETROFIT
import com.bornasumiga.githubreposearch.repoList.ui.RepoListItemListener
import com.bornasumiga.githubreposearch.repoList.ui.RepoListRecyclerAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val repoListModule = module {
    factory { provideRepoListInterface(get(named(REPO_LIST_RETROFIT))) }
    factory { RepoListInteractor(get()) }
    single { RepoListViewModel(get()) }
    factory { (repoListItemListener:RepoListItemListener)->RepoListRecyclerAdapter(repoListItemListener) }
}

private fun provideRepoListInterface(retrofit: Retrofit) = retrofit.create(RepoListInterface::class.java)