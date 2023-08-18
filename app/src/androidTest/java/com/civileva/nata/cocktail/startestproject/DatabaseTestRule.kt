package com.civileva.nata.cocktail.startestproject

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.civileva.nata.cocktail.startestproject.db.StarWarsDB
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class DatabaseTestRules : TestWatcher() {
	var database: StarWarsDB? = null

	override fun starting(description: Description) {
		super.starting(description)
		val context = InstrumentationRegistry.getInstrumentation().context
		database = createInMemoryDatabase(context)
	}

	override fun finished(description: Description) {
		super.finished(description)
		database?.close()
		database = null
	}

	private fun createInMemoryDatabase(context: Context) =
		Room.inMemoryDatabaseBuilder(context, StarWarsDB::class.java)
			.allowMainThreadQueries()
			.build()

}