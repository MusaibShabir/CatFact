package com.musaib.catfact.netwrok

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class CatFactApiService @Inject constructor(
    private val client: HttpClient
) {
    private val BASE_URL = "https://catfact.ninja/fact"

    suspend fun getCatFact(): CatFact {
        return client.get(BASE_URL).body()
    }
}