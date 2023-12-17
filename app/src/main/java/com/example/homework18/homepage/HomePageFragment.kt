package com.example.homework18.homepage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework18.AdapterPagingRecycler
import com.example.homework18.BaseFragment
import com.example.homework18.HomePageViewModel
import com.example.homework18.databinding.FragmentHomePageBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    private val viewModel : HomePageViewModel by viewModels()
    private lateinit var myAdaper: AdapterPagingRecycler

    override fun setUp() {
        Log.d("tag123","setup")
        myAdaper = AdapterPagingRecycler()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdaper
        }

        lifecycleScope.launch {
            viewModel.usersFlow.collectLatest { pagingData ->
                myAdaper.submitData(pagingData)
            }
        }

    }

    private fun loadPage(numberOfPage:Int){

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomePageFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}