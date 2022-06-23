package com.arsenka.movieshomeworkapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesDetailsBinding
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesListBinding

class MoviesDetailsFragment : Fragment(R.layout.fragment_movies_details) {

    private var binding: FragmentMoviesDetailsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesDetailsBinding.bind(view)

        binding?.ivBack?.setOnClickListener {
          findNavController().popBackStack()

        }
    }
}

