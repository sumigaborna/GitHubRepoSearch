package com.bornasumiga.githubreposearch.RepoList.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.RepoList.interactor.RepoListInteractor
import com.bornasumiga.githubreposearch.RepoList.view_model.RepoListViewModel
import org.koin.android.ext.android.inject

class RepoListActivity : AppCompatActivity() {

    private val viewModel by inject<RepoListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
        initUI()
    }

    private fun initUI() {

    }
}