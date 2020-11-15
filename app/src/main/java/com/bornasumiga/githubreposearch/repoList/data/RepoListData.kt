package com.bornasumiga.githubreposearch.repoList.data

data class RepoListResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<RepoListItem>
)

data class RepoListItem(
    val id:Int,
    val repoName:String,
    val lastUpdateTime:String,
    val dataType : Int
)

data class RepoListUI(
    val items: List<RepoListItem> = mutableListOf()
)

fun provideRepoListUI(repoListResponse: RepoListResponse):RepoListUI{
    //TODO: THIS IS TEMPORARY UNTIL DESIGN IS DECIDED
    return RepoListUI(listOf())
}