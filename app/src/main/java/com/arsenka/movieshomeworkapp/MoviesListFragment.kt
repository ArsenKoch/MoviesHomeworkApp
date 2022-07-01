package com.arsenka.movieshomeworkapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesListBinding

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private var binding: FragmentMoviesListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesListBinding.bind(view)

        binding?.movieContainer?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMoviesList_to_fragmentMoviesDetails)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}



