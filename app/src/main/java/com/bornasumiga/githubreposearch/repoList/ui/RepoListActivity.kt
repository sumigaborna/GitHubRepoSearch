package com.bornasumiga.githubreposearch.repoList.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.app.common.KEY_ITEM_ID
import com.bornasumiga.githubreposearch.app.common.hideProgressBar
import com.bornasumiga.githubreposearch.app.common.showFragment
import com.bornasumiga.githubreposearch.app.common.showProgressBar
import com.bornasumiga.githubreposearch.repoList.view_model.RepoListViewModel
import kotlinx.android.synthetic.main.activity_repo_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RepoListActivity : AppCompatActivity(), RepoListItemListener {

    private val viewModel by inject<RepoListViewModel>()
    private val recyclerAdapter by inject<RepoListRecyclerAdapter>{ parametersOf(this)}

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
        rvRepoList.adapter = recyclerAdapter
        rvRepoList.layoutManager = LinearLayoutManager(this)
        //Setting search logic
        svRepoName.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return if(query.isNotBlank()){
                    val disposable = viewModel.getRepoList(query)
                        .doOnSubscribe { showProgressBar(pbRepoList) }
                        .doOnComplete { hideProgressBar(pbRepoList) }
                        .subscribe()
                    viewModel.addDisposable(disposable)
                    svRepoName.clearFocus()
                    true
                }
                else false
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    override fun onItemClick(itemId:Int) {
        val bundle = Bundle()
        bundle.putInt(KEY_ITEM_ID,itemId)
        showFragment(R.id.repoListFragmentContainer, RepoDetailsFragment(), true,bundle)
    }
}

interface RepoListItemListener{
    fun onItemClick(itemId:Int)
}