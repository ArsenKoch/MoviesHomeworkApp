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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

