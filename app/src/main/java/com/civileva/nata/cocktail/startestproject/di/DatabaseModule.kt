package com.civileva.nata.cocktail.startestproject.di

import android.content.Context
import androidx.room.Room
import com.civileva.nata.cocktail.startestproject.db.StarWarsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

	@Singleton
	@Provides
	fun provideDatabase(@ApplicationContext context: Context):StarWarsDB = Room
		.databaseBuilder(
			context,
			StarWarsDB::class.java,
			"StarWarsDatabase"
		)
		.build()

}