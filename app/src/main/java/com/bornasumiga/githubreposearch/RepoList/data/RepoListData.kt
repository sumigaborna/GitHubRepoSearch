package com.bornasumiga.githubreposearch.RepoList.data

data class RepoListResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<RepoListItems>
)

data class RepoListItems(val id:Int)