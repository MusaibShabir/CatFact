package com.musaib.catfact.netwrok

import javax.inject.Inject


class CatFactRepository @Inject constructor(
    private val apiService: CatFactApiService
) {
    suspend fun fetchCatFact(): CatFact {
        return apiService.getCatFact()
    }
}