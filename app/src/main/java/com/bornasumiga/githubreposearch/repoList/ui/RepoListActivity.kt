package com.bornasumiga.githubreposearch.repoList.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.repoList.view_model.RepoListViewModel
import org.koin.android.ext.android.inject

class RepoListActivity : AppCompatActivity() {

    private val viewModel by inject<RepoListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
        observeLiveData()
        initUI()
    }

    private fun observeLiveData(){
        viewModel.repoListData.observe(
            this,
            Observer {
                //TODO: Send to adapter
            }
        )
    }

    private fun initUI() = viewModel.getRepoList("DementiaHelper")
}