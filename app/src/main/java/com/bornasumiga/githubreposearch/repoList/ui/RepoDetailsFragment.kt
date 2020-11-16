package com.bornasumiga.githubreposearch.repoList.ui

import BaseFragment
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.app.common.KEY_ITEM_ID
import com.bornasumiga.githubreposearch.repoList.view_model.RepoListViewModel
import kotlinx.android.synthetic.main.activity_repo_list.*
import kotlinx.android.synthetic.main.fragment_repo_details.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RepoDetailsFragment : BaseFragment() {

    private val viewModel by inject<RepoListViewModel>()

    override fun getLayout(): Int = R.layout.fragment_repo_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = viewModel.repoListData.value?.items?.find { it.id==arguments!!.getInt(KEY_ITEM_ID) }
        tvRepoName.text = data?.repoName
        tvLastUpdateTime.text = data?.lastUpdateTime
        tvOwnerName.text = data?.owner
        tvRepoDescription.text = data?.description
    }
}