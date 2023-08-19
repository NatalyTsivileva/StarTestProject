package com.civileva.nata.cocktail.startestproject.presentation.ui.search.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.civileva.nata.cocktail.startestproject.R

class SearchItemDecorator(private val context: Context?) : DividerItemDecoration(context,VERTICAL) {

	override fun getItemOffsets(
		outRect: Rect,
		view: View,
		parent: RecyclerView,
		state: RecyclerView.State
	) {
		val side = context?.resources?.getDimension(R.dimen.d2)?.toInt() ?: 0
		val bottom = context?.resources?.getDimension(R.dimen.d3)?.toInt() ?: 0
		outRect.set(side, 0, side, bottom)
	}

}