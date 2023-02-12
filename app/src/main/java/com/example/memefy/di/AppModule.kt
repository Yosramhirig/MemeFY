package com.example.memefy.di
import com.example.memefy.Model.Getmemes.MemesApiImp
import com.example.memefy.Model.Getmemes.MemesApiImp2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 11,Feb,2023
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides //tells dagger hilt this is a recipe ;)
    @Singleton //only one instance will be shared between our viewModels
    fun provideKtorClient(): HttpClient {
        val client = HttpClient(Android) {
            expectSuccess = true
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
        return client
    }

    @Provides
    @Singleton
    fun providePostApi(httpClient: HttpClient):MemesApiImp {
        return MemesApiImp(httpClient)
    }

    @Provides
    @Singleton
    fun providePostApi2(httpClient: HttpClient): MemesApiImp2 {
        return MemesApiImp2(httpClient)
    }
}