package com.arsenka.movieshomeworkapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesListBinding

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private var binding: FragmentMoviesListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesListBinding.bind(view)

        binding?.rvMovies?.layoutManager = GridLayoutManager(context, 2)
        val adapter = MoviesListAdapter(
            listOf(
                MoviesListItem(
                    "Avengers : End Game",
                    "13+",
                    "Action, Adventure, Drama",
                    "125 REVIEWS",
                    "137 MIN",
                    false,
                    R.drawable.movie_list,
                    4
                ),
                MoviesListItem(
                    "Tenet",
                    "16+",
                    "Action, Sci-Fi, Thriller",
                    "98 REVIEWS",
                    "97 MIN",
                    true,
                    R.drawable.movie_tenet,
                    5
                ),
                MoviesListItem(
                    "Black Widow",
                    "13+",
                    "Action, Sci-Fi, Thriller",
                    "38 REVIEWS",
                    "102 MIN",
                    false,
                    R.drawable.movie_blwidow,
                    4
                ),
                MoviesListItem(
                    "Wonder Woman 1984",
                    "13+",
                    "Action, Adventure, Fantasy",
                    "74 REVIEWS",
                    "120 MIN",
                    false,
                    R.drawable.movie_ww84,
                    5
                )
            )
        )
        adapter.setOnClickListener(object : MoviesListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                findNavController().navigate(R.id.action_fragmentMoviesList_to_fragmentMoviesDetails)

            }
        })
        binding?.rvMovies?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}