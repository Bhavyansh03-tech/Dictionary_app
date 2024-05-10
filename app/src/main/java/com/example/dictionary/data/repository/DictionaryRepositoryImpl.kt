package com.example.dictionary.data.repository

import android.app.Application
import com.example.dictionary.R
import com.example.dictionary.data.api.DictionaryApi
import com.example.dictionary.data.mapper.toWordItem
import com.example.dictionary.domain.model.WordItem
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {

    override suspend fun getWordResult(word: String): Flow<Result<WordItem>> {
        return flow {
            // Loading Data :->
            emit(Result.Loading(true))

            // Try and catching data and errors :->
            val remoteWordResultDto = try{
                dictionaryApi.getWordResult(word)
            } catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_get_data)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_get_data)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.can_get_data)))
                emit(Result.Loading(false))
                return@flow
            }

            // Getting Data :->
            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0].let { wordItemDto ->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                }
            }

            // If by chance data is null then show this error :->
            emit(Result.Error(application.getString(R.string.can_get_data)))
            emit(Result.Loading(false))
        }
    }

}