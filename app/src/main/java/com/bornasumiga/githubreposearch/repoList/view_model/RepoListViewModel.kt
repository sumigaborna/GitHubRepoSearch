package com.bornasumiga.githubreposearch.repoList.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bornasumiga.githubreposearch.app.base.BaseViewModel
import com.bornasumiga.githubreposearch.repoList.data.RepoListUI
import com.bornasumiga.githubreposearch.repoList.data.provideRepoListUI
import com.bornasumiga.githubreposearch.repoList.interactor.RepoListInteractor

class RepoListViewModel(private val interactor: RepoListInteractor) : BaseViewModel(){

    private val _repoListData = MutableLiveData<RepoListUI>()
    val repoListData : LiveData<RepoListUI> = _repoListData

    fun getRepoList(repoName:String) =
        addDisposable(
            interactor
            .getReposByName(repoName)
            .map { provideRepoListUI(it) }
            .doOnNext { _repoListData.value = it }
            .subscribe()
        )
}