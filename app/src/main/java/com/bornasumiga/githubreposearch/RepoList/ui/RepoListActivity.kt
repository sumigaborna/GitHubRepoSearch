package com.bornasumiga.githubreposearch.RepoList.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.RepoList.interactor.RepoListInteractor
import org.koin.android.ext.android.inject

class RepoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
    }
}