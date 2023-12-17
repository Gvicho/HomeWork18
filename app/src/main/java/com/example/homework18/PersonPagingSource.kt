package com.example.homework18

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework18.remote.GetPersonsAPI
import retrofit2.HttpException

class PersonPagingSource (
    private val apiService: GetPersonsAPI
) : PagingSource<Int, Person>() {

    var numberOfPages = -1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        val currentPage = params.key ?: 1
        Log.d("tag123","loading ${currentPage}")
        return try {
            val response = apiService.getUsers(currentPage)
            val body = response.body()

            if (response.isSuccessful && body != null) {
                val responseData = body.data
                val nextPageNumber = if (currentPage < body.totalPages) currentPage + 1 else null
                val prevPageNumber = if (currentPage > 1) currentPage - 1 else null

                // Here you can access other elements like body.page, body.total, etc.

                LoadResult.Page(
                    data = responseData,
                    prevKey = prevPageNumber,
                    nextKey = nextPageNumber
                )
            } else {
                LoadResult.Error(NetworkErrorException())
            }
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {

        return state.anchorPosition
    }
}