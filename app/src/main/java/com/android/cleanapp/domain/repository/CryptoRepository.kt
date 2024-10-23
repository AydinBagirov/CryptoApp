package com.android.cleanapp.domain.repository

import com.android.cleanapp.data.remote.dto.CyrptoDto

interface CryptoRepository {
    suspend fun getCrypto(): CyrptoDto
}