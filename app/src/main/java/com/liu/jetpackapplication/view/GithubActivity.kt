package com.liu.jetpackapplication.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liu.jetpackapplication.R
import com.liu.jetpackapplication.adapter.FooterAdapter
import com.liu.jetpackapplication.adapter.GithubAdapter
import com.liu.jetpackapplication.viewmodel.GithubViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubActivity : AppCompatActivity() {
    private val githubViewModel = GithubViewModel()
    private val githubAdapter = GithubAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            githubAdapter.withLoadStateFooter(FooterAdapter { githubAdapter.retry() })
        lifecycleScope.launch {
            githubViewModel.getPagingData().collect {
                githubAdapter.submitData(it)
            }
        }
        githubAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    progressBar.visibility = View.INVISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                is LoadState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.INVISIBLE
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, "Load Error: ${state.error.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}