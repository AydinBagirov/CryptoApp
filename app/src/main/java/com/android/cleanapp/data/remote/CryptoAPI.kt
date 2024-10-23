package com.android.cleanapp.data.remote

import com.android.cleanapp.data.remote.dto.CyrptoDto
import com.android.cleanapp.util.Constants.API_KEY
import com.android.cleanapp.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {
    @GET("economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ):CyrptoDto
}
