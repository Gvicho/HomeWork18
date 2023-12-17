package com.example.homework18

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.homework17_leacture20.data.remote.Network
import kotlinx.coroutines.flow.StateFlow


class HomePageViewModel() : ViewModel() {

    val usersFlow = Pager(
        config = PagingConfig(pageSize = 6, enablePlaceholders = true, initialLoadSize = 6),
        pagingSourceFactory = { PersonPagingSource(Network.getPersonAPI) }
    ).flow.cachedIn(viewModelScope)

}