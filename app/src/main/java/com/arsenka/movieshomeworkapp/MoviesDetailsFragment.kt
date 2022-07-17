package com.arsenka.movieshomeworkapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesDetailsBinding

class MoviesDetailsFragment : Fragment(R.layout.fragment_movies_details) {

    private var binding: FragmentMoviesDetailsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesDetailsBinding.bind(view)

        binding?.ivBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        val adapter = ActorsAdapter(
            listOf(
                ActorsListItem("Robert Downey Jr.",R.drawable.movie_3),
                ActorsListItem("Chris Evans",R.drawable.movie_2),
                ActorsListItem("Mark Ruffalo",R.drawable.movie_1),
                ActorsListItem("Chris Hemsworth",R.drawable.movie_4)
            )
        )
        binding?.rvCast?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


//todo()
