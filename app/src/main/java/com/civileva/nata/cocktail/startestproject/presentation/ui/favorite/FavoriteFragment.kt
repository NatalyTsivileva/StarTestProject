package com.civileva.nata.cocktail.startestproject.presentation.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.civileva.nata.cocktail.startestproject.R

class FavoriteFragment : Fragment(R.layout.fr_favorite) {
	private val viewModel: FavoriteViewModel by viewModels { FavoriteViewModel.FavoriteStarWarsViewModel }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
}