package com.bornasumiga.githubreposearch.RepoList.interactor

import com.bornasumiga.githubreposearch.RepoList.rest_interface.RepoListInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoListInteractor(private val restInterface: RepoListInterface){
    fun getReposByName(repoName:String) =
        restInterface.getReposByName(repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}