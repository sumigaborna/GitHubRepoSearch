package com.bornasumiga.githubreposearch.repoList.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.repoList.view_model.RepoListViewModel
import kotlinx.android.synthetic.main.activity_repo_list.*
import org.koin.android.ext.android.inject

class RepoListActivity : AppCompatActivity() {

    private val viewModel by inject<RepoListViewModel>()
    private val recyclerAdapter by inject<RepoListRecyclerAdapter>()

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
                recyclerAdapter.setData(it)
            }
        )
    }

    private fun initUI() {
        viewModel.getRepoList("DementiaHelper")
        rvRepoList.adapter = recyclerAdapter
        rvRepoList.layoutManager = LinearLayoutManager(this)
    }
}