package com.bornasumiga.githubreposearch.repoList.data

import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.app.common.localizeDate
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class RepoListResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<RepoListResponseItem>
)

data class RepoListResponseItem(
    val id:Int,
    val name:String,
    val full_name:String,
    val updated_at:String,
    val owner: RepoOwner,
    val description:String?
)

data class RepoOwner(
    val login:String
)

data class RepoListUI(
    val items: List<RepoListUIItem>
)

data class RepoListUIItem(
    val id:Int,
    val repoName:String,
    val owner:String,
    val lastUpdateTime:String,
    val description: String,
    val dataType : Int
)

fun provideRepoListUI(repoListResponse: RepoListResponse):RepoListUI{
    val sortedItems = repoListResponse.items as MutableList
    sortedItems.sortByDescending {
        it.updated_at.substring(0,10)
    }
    val items = mutableListOf<RepoListUIItem>()
    sortedItems.forEach {
        items.add(RepoListUIItem(it.id,it.name,it.owner.login, localizeDate(it.updated_at),it.description ?: "", R.layout.item_repository))
    }
    return RepoListUI(items)
}