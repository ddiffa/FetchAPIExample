package dev.hellodiffa.fetchapiexampel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hellodiffa.fetchapiexampel.R
import dev.hellodiffa.fetchapiexampel.common.ResultState
import dev.hellodiffa.fetchapiexampel.model.ArticlesItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : NewsAdapter
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = NewsViewModel()
        adapter = NewsAdapter()

        rvNews.layoutManager = LinearLayoutManager(applicationContext)
        rvNews.adapter = adapter

        viewModel.news.observe(this, Observer {
            when(it.status){
                ResultState.Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                ResultState.Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(applicationContext, it.errorMessage, Toast.LENGTH_LONG).show()
                }
                ResultState.Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    if (it.data?.articles!=null) adapter.dataSource = it.data.articles
                }
            }
        })
    }
}