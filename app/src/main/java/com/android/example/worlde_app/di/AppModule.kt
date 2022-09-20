package com.android.example.worlde_app.di

import com.android.example.worlde_app.data.remote.DictionaryAPI
import com.android.example.worlde_app.data.repository.DictionaryRepositoryImpl
import com.android.example.worlde_app.data.repository.GameRepositoryImpl
import com.android.example.worlde_app.domain.repository.DictionaryRepository
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDictionaryApi() : DictionaryAPI {
        return Retrofit.Builder()
            .baseUrl("https://burakgizlice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDictionaryRepository(api: DictionaryAPI) : DictionaryRepository {
        return DictionaryRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGameRepository() : GameRepository {
        return GameRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideWordleUseCases(repository: GameRepository) : WordleUseCases {
        return WordleUseCases(
            addLetter = AddLetter(repository),
            deleteLetter = DeleteLetter(repository),
            submitGuess = SubmitGuess(repository),
            toggleHowToPlay = ToggleHowToPlay(repository),
            toggleLose = ToggleLose(repository),
            toggleStats = ToggleStats(repository),
            toggleWin = ToggleWin(repository)
        )
    }
}