package com.bornasumiga.githubreposearch.repoList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.repoList.data.RepoListItem
import com.bornasumiga.githubreposearch.repoList.data.RepoListUI
import kotlinx.android.synthetic.main.item_repository.view.*

class RepoListRecyclerAdapter : RecyclerView.Adapter<RepoListRecyclerAdapter.RepoListViewHolder>(){

    private val repoList = RepoListUI()

    override fun getItemCount(): Int = repoList.items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType,parent,false)
        return when(viewType){
            R.layout.item_repository -> RepoListViewHolder(view)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.bind(repoList.items[position])
    }

    override fun getItemViewType(position: Int): Int = repoList.items[position].dataType

    inner class RepoListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        override fun bind(item:RepoListItem){
            itemView.tvItemRepoName.text = item.repoName
        }
    }
}



