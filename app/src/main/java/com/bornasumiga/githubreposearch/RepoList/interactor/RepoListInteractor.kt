package com.bornasumiga.githubreposearch.RepoList.interactor

import com.bornasumiga.githubreposearch.RepoList.rest_interface.RepoListInterface

class RepoListInteractor(private val restInterface: RepoListInterface){
    fun getReposByName(repoName:String) =
        restInterface.getReposByName(repoName)

}