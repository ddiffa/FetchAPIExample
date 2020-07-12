package dev.hellodiffa.fetchapiexampel.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.hellodiffa.fetchapiexampel.R
import dev.hellodiffa.fetchapiexampel.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var dataSource = listOf<ArticlesItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent, false))

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataSource[position])
    }

    inner class ViewHolder(private  val view : View) : RecyclerView.ViewHolder(view){
        fun onBind(article : ArticlesItem) =view.apply {
            Picasso.get().load(article.urlToImage).into(imgNews)
            tvTitleNews.text = article.title
            tvDescriptionNews.text = article.description
        }
    }
}