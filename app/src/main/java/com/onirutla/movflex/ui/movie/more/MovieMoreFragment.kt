package com.onirutla.movflex.ui.movie.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.onirutla.movflex.core.ui.ContentPagingAdapter
import com.onirutla.movflex.databinding.FragmentMovieMoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieMoreFragment : Fragment() {

    private var _binding: FragmentMovieMoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieMoreViewModel by viewModels()

    private val args: MovieMoreFragmentArgs by navArgs()

    private val movieMoreAdapter by lazy {
        ContentPagingAdapter { view, content ->
            view.findNavController().navigate(
                MovieMoreFragmentDirections.actionMovieMoreFragmentToMovieDetailFragment(content.id)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = args.movieType
        viewModel.getMovieByCategory(category)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moviePaging.apply {
            adapter = movieMoreAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.toolbar.apply {
            title = args.movieType.value
            setOnClickListener { it.findNavController().navigateUp() }
        }

        viewModel.movieMore.observe(viewLifecycleOwner) {
            movieMoreAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}