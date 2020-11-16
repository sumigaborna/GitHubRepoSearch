package com.bornasumiga.githubreposearch.repoList.data

import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.app.common.localizeDate

data class RepoListResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<RepoListResponseItem>
)

data class RepoListResponseItem(
    val id:Int,
    val name:String,
    val full_name:String,
    val updated_at:String
)

data class RepoListUI(
    val items: List<RepoListUIItem>
)

data class RepoListUIItem(
    val id:Int,
    val repoName:String,
    val lastUpdateTime:String,
    val dataType : Int
)

fun provideRepoListUI(repoListResponse: RepoListResponse):RepoListUI{
    val items = mutableListOf<RepoListUIItem>()
    repoListResponse.items.forEach {
        items.add(RepoListUIItem(it.id,it.full_name, localizeDate(it.updated_at), R.layout.item_repository))
    }
    return RepoListUI(items)
}