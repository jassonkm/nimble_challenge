package co.jassonkm.nimblechallenge.di

import android.content.Context
import co.jassonkm.nimblechallenge.data.remote.repository.LoginRepository
import co.jassonkm.nimblechallenge.data.remote.repository.SurveyRepository
import co.jassonkm.nimblechallenge.data.remote.repository.impl.LoginRepositoryImpl
import co.jassonkm.nimblechallenge.data.remote.repository.impl.SurveyRepositoryImpl
import co.jassonkm.nimblechallenge.util.DateProvider
import co.jassonkm.nimblechallenge.util.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository = loginRepositoryImpl

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }
    @Provides
    @Singleton
    fun provideSurveyRepository(surveyRepositoryImpl: SurveyRepositoryImpl): SurveyRepository = surveyRepositoryImpl

    @Provides
    @Singleton
    fun provideDateProvider(): DateProvider = DateProvider()
}