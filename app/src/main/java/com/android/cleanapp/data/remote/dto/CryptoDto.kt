package com.android.cleanapp.data.remote.dto

import com.android.cleanapp.domain.model.Cryptomodel

data class CyrptoDto(
    val result: List<Result>,
    val success: Boolean
)

fun CyrptoDto.toCrypto(): List<Cryptomodel>{
    return result.map {
        Cryptomodel(
            code = it.code,
            pricestr = it.pricestr,
            currency = it.currency
        )
    }
}