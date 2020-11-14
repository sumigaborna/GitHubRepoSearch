package com.bornasumiga.githubreposearch.RepoList.rest_interface

import com.bornasumiga.githubreposearch.RepoList.data.RepoListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoListInterface {
    @GET("/search/repositories")
    fun getReposByName(
        @Query("q") repoName:String
    ): Observable<RepoListResponse>
}