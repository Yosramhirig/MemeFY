package com.example.memefy.Model.Getmemes

import android.util.Log
import com.example.memefy.util.Routes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import java.util.Objects
import kotlin.text.get

class MemesApiImp (
    private val client: HttpClient
    ): MemesApi {

        override suspend fun getMemes(): Getsmemes{
               return client.get {
                    url(Routes.wholsome)
                }.body()

        }
}