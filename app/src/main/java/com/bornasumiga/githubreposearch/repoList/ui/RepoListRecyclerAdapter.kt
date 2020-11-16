package com.bornasumiga.githubreposearch.repoList.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bornasumiga.githubreposearch.R
import com.bornasumiga.githubreposearch.repoList.data.RepoListUI
import com.bornasumiga.githubreposearch.repoList.data.RepoListUIItem
import kotlinx.android.synthetic.main.item_repository.view.*

class RepoListRecyclerAdapter(private val clickListener: RepoListItemListener) : RecyclerView.Adapter<RepoListRecyclerAdapter.RepoListViewHolder>(){

    private var repoList = RepoListUI(emptyList())

    fun setData(repoListUI: RepoListUI){
        repoList = repoListUI
        notifyDataSetChanged()
    }

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
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(repoList.items[position].id)
        }
    }

    override fun getItemViewType(position: Int): Int = repoList.items[position].dataType

    inner class RepoListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(item:RepoListUIItem){
            itemView.tvItemRepoName.text = item.repoName
            itemView
        }
    }
}



