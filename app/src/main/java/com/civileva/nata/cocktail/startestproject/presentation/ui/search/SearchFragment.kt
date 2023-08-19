package com.civileva.nata.cocktail.startestproject.presentation.ui.search

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.civileva.nata.cocktail.startestproject.R
import com.civileva.nata.cocktail.startestproject.presentation.ui.Loading
import com.civileva.nata.cocktail.startestproject.presentation.ui.Success
import com.civileva.nata.cocktail.startestproject.presentation.ui.search.adapter.SearchItemDecorator
import com.civileva.nata.cocktail.startestproject.presentation.ui.search.adapter.SearchRecyclerAdapter
import kotlinx.coroutines.launch

class SearchFragment : Fragment(R.layout.fr_search) {

	private val viewModel: SearchViewModel by viewModels { SearchViewModel.SearchViewModelProvider }
	private var recyclerView: RecyclerView? = null
	private var recyclerAdapter: SearchRecyclerAdapter? = null


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		view.findViewById<EditText>(R.id.searchBar)?.doOnTextChanged { text, start, before, count ->
			val actualCharCount = text?.toString()?.count() ?: 0
			if (actualCharCount > 2) {
				viewModel.search(text.toString())
			}
		}

		recyclerView = view.findViewById(R.id.recyclerView)
		recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
		recyclerAdapter = SearchRecyclerAdapter()
		recyclerView?.adapter = recyclerAdapter
		recyclerView?.addItemDecoration(SearchItemDecorator(context))


		viewLifecycleOwner.lifecycleScope.launch {
			viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.searched.collect { state ->
					when (state) {
						is Loading -> {}
						is Success -> {
							recyclerAdapter?.submitList(state.data)
						}
						is com.civileva.nata.cocktail.startestproject.presentation.ui.Error -> {
							Toast.makeText(context, "Ошибка${state.message}", Toast.LENGTH_LONG)
								.show()
						}
						else -> {}
					}

				}
			}
		}
	}
}