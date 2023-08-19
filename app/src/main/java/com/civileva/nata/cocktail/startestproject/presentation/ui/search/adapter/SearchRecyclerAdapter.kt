package com.civileva.nata.cocktail.startestproject.presentation.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.civileva.nata.cocktail.startestproject.R
import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.data.model.Planet
import com.civileva.nata.cocktail.startestproject.data.model.Starship

class SearchRecyclerAdapter() : ListAdapter<ListItem, ListItemViewHolder>(searchDiffUtils) {


	override fun getItemViewType(position: Int): Int = when (getItem(position)) {
		is Person -> PERSON_TYPE
		is Starship -> STARSHIP_TYPE
		is Planet -> PLANET_TYPE
		else -> UNDEFINED_TYPE
	}


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder =
		when (viewType) {
			PERSON_TYPE -> {
				val layout = R.layout.item_search_person
				val view = LayoutInflater.from(parent.context).inflate(layout, parent)
				SearchPersonViewHolder(view)
			}
			STARSHIP_TYPE -> {
				val layout = R.layout.item_search_starship
				val view = LayoutInflater.from(parent.context).inflate(layout, parent)
				SearchStarshipViewHolder(view)
			}
			PLANET_TYPE -> {
				val layout = R.layout.item_search_planet
				val view = LayoutInflater.from(parent.context).inflate(layout, parent)
				SearchPlanetViewHolder(view)
			}
			else -> {
				val layout = R.layout.item_empty
				val view = LayoutInflater.from(parent.context).inflate(layout, parent)
				ListItemViewHolder(view)
			}

		}

	override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
		holder.bind(getItem(position))
	}


	companion object {
		val searchDiffUtils = object : DiffUtil.ItemCallback<ListItem>() {
			override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
				return oldItem.id == newItem.id
			}

			override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
				return oldItem.equals(newItem)
			}
		}

		const val PERSON_TYPE = 1
		const val PLANET_TYPE = 2
		const val STARSHIP_TYPE = 3
		const val UNDEFINED_TYPE = 4
	}
}