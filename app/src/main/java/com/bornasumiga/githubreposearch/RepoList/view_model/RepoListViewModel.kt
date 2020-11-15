package com.bornasumiga.githubreposearch.RepoList.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bornasumiga.githubreposearch.RepoList.data.RepoListUI
import com.bornasumiga.githubreposearch.RepoList.data.provideRepoListUI
import com.bornasumiga.githubreposearch.RepoList.interactor.RepoListInteractor
import com.bornasumiga.githubreposearch.app.base.BaseViewModel
import io.reactivex.Observable

class RepoListViewModel(private val interactor: RepoListInteractor) : BaseViewModel(){

    private val _repoListData = MutableLiveData<RepoListUI>()
    private val repoListData : LiveData<RepoListUI> = _repoListData

    fun getRepoList(repoName:String) : Observable<RepoListUI> =
        interactor
            .getReposByName(repoName)
            .map { provideRepoListUI(it) }
            .doOnNext { _repoListData.value = it }
}