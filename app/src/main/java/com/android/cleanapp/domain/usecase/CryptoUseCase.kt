package com.android.cleanapp.domain.usecase

import com.android.cleanapp.data.remote.dto.toCrypto
import com.android.cleanapp.domain.model.Cryptomodel
import com.android.cleanapp.domain.repository.CryptoRepository
import com.android.cleanapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) {
    fun getCrypto():Flow<Resource<List<Cryptomodel>>> = flow {
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success){
                 emit(Resource.Success(crypto.toCrypto()))
            }else{
                emit(Resource.Error("No Crypto Found"))
            }
        }catch (e: HttpException){
            emit(Resource.Error("${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("${e.localizedMessage}"))
        }
    }
}