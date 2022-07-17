package com.arsenka.movieshomeworkapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arsenka.movieshomeworkapp.data.JsonGenre
import com.arsenka.movieshomeworkapp.data.JsonMovie
import com.arsenka.movieshomeworkapp.databinding.FragmentMoviesListBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.InputStream

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private var binding: FragmentMoviesListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesListBinding.bind(view)


        binding?.rvMovies?.layoutManager = GridLayoutManager(context, 2)
        val adapter = MoviesListAdapter(context!!)
        adapter.setOnClickListener(object : MoviesListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                findNavController().navigate(R.id.action_fragmentMoviesList_to_fragmentMoviesDetails)

            }
        })
        binding?.rvMovies?.adapter = adapter
        adapter.addData(loadMovies(context!!))
    }

    fun loadMovies(context: Context): List<MoviesListItem> {
        val inputStream: InputStream = context.assets.open("data.json")
        val byte = inputStream.readBytes()
        inputStream.close()
        val json = String(byte, Charsets.UTF_8)
        val format = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
        val data = format.decodeFromString<List<JsonMovie>>(json)
        var allGenre = loadGenres(context)
        val list: List<MoviesListItem> = data.map { jsonMovie ->
            MoviesListItem(
                titleName = jsonMovie.title,
                age = if (jsonMovie.adult) "18+" else "13+",
                genres = findItemsById(allGenre,jsonMovie.genreIds).joinToString(),
                reviews = jsonMovie.votesCount.toString(),
                time = jsonMovie.runtime.toString(),
                ivPoster = jsonMovie.posterPicture,
                ivFavourite = false,
                rating = jsonMovie.votesCount
            )
        }

        Log.d(TAG, "loadMovies: $data")
        return list
    }

    fun loadGenres(context: Context) : List<JsonGenre> {
        val inputStream: InputStream = context.assets.open("genres.json")
        val byte = inputStream.readBytes()
        inputStream.close()
        val jsonGenres = String(byte, Charsets.UTF_8)
        val format = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
       return format.decodeFromString<List<JsonGenre>>(jsonGenres)
    }

    fun findItemsById(listGenres: List<JsonGenre>, listGenresIds: List<Int>): List<String> {
        return listGenresIds.map { genreIds ->
            listGenres.find { genre ->
                genre.id == genreIds
            }!!.name
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

private const val TAG = "MoviesListFragment"