package co.jassonkm.nimblechallenge.di

import co.jassonkm.nimblechallenge.data.remote.api.ApiServiceSurvey
import co.jassonkm.nimblechallenge.util.Constants
import co.jassonkm.nimblechallenge.util.InterceptorToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleSurvey {
    @Provides
    @Singleton
    @Named("survey")
    fun provideOkHttpClient(
        tokenInterceptor: InterceptorToken,
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
        return okHttpClientBuilder.build()
    }


    @Provides
    @Singleton
    @Named("survey")
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }



    @Singleton
    @Provides
    @Named("survey")
    fun provideRetrofit( @Named("survey") okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    @Named("survey")
    fun provideApiService(@Named("survey")retrofit: Retrofit): ApiServiceSurvey = retrofit.create(ApiServiceSurvey::class.java)
}