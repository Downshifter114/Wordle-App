package com.android.example.worlde_app.di

import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.data.repository.GameRepositoryImpl
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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