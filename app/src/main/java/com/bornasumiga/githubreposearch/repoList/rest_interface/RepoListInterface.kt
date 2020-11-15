package com.bornasumiga.githubreposearch.repoList.rest_interface

import com.bornasumiga.githubreposearch.repoList.data.RepoListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoListInterface {
    @GET("/search/repositories")
    fun getReposByName(
        @Query("q") repoName:String
    ): Observable<RepoListResponse>
}