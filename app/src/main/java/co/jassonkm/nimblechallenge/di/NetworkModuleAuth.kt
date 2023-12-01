package co.jassonkm.nimblechallenge.di

import co.jassonkm.nimblechallenge.data.remote.api.ApiServiceAuth
import co.jassonkm.nimblechallenge.util.Constants
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleAuth {

    @Singleton
    @Provides
    @Named("auth")
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named("auth")
    fun providesOkHttpClient(@Named("auth")httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
    @Singleton
    @Provides
    @Named("auth")
    fun provideRetrofit(@Named("auth")okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
    @Singleton
    @Provides
    @Named("auth")
    fun provideApiService(@Named("auth")retrofit: Retrofit): ApiServiceAuth = retrofit.create(ApiServiceAuth::class.java)


}