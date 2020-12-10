package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.R

import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Movie

import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val movies: ArrayList<Movie>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.textViewMovieName.text = movie.title
            itemView.textViewMovieOverview.text = movie.overview
            Glide.with(itemView.imageViewPoster.context)
                .load("https://image.tmdb.org/t/p/w500"+ movie.poster_path)
                .into(itemView.imageViewPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(movies[position])

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }
}