package com.civileva.nata.cocktail.startestproject.presentation.ui.search.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.civileva.nata.cocktail.startestproject.R
import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.data.model.Planet
import com.civileva.nata.cocktail.startestproject.data.model.Starship

open class ListItemViewHolder(itemView: View) : ViewHolder(itemView) {
	open fun bind(data: ListItem) {

	}
}


class SearchPersonViewHolder(itemView: View) : ListItemViewHolder(itemView) {
	val name: TextView = itemView.findViewById(R.id.name)
	val gender: TextView = itemView.findViewById(R.id.gender)
	val starship: TextView = itemView.findViewById(R.id.starship)

	override fun bind(data: ListItem) {
		if (data is Person) {
			name.text = data.name
			gender.text = data.gender.name.lowercase()
			starship.text = data.starshipsCount.toString()
		}
	}
}

class SearchPlanetViewHolder(itemView: View) : ListItemViewHolder(itemView) {
	val name: TextView = itemView.findViewById(R.id.name)
	val diameter: TextView = itemView.findViewById(R.id.diameter)
	val population: TextView = itemView.findViewById(R.id.population)

	override fun bind(data: ListItem) {
		if (data is Planet) {
			name.text = data.name
			diameter.text = data.diameter.toString()
			population.text = data.populationInfo

		}
	}
}

class SearchStarshipViewHolder(itemView: View) : ListItemViewHolder(itemView) {
	val name: TextView = itemView.findViewById(R.id.name)
	val model: TextView = itemView.findViewById(R.id.model)
	val manufacturer: TextView = itemView.findViewById(R.id.manufacturer)
	val passengers: TextView = itemView.findViewById(R.id.passengers)

	override fun bind(data: ListItem) {
		if (data is Starship) {
			name.text = data.name
			model.text = data.model
			manufacturer.text = data.manufacturer
			passengers.text = data.passengersInfo
		}
	}
}