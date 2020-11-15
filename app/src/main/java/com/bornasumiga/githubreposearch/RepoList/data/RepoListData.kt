package com.bornasumiga.githubreposearch.RepoList.data

data class RepoListResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<RepoListItems>
)

data class RepoListItems(
    val id:Int
)

data class RepoListUI(
    val temp : String
)

fun provideRepoListUI(repoListResponse: RepoListResponse):RepoListUI{
    TODO()
}