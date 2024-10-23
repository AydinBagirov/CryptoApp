package com.android.cleanapp.data.repository

import com.android.cleanapp.data.remote.CryptoAPI
import com.android.cleanapp.data.remote.dto.CyrptoDto
import com.android.cleanapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoAPI
): CryptoRepository {
    override suspend fun getCrypto(): CyrptoDto {
        return cryptoAPI.getCrypto()
    }
}