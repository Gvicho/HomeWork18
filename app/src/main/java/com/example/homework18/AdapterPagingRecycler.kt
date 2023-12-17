package com.example.homework18

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework18.databinding.PersonItemRecyclerBinding
import androidx.paging.PagingDataAdapter
import com.bumptech.glide.Glide

class AdapterPagingRecycler : PagingDataAdapter<Person, AdapterPagingRecycler.PersonViewHolder>(UserComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PersonItemRecyclerBinding.inflate(inflater, parent, false)
        return PersonViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        person?.let {
            holder.bind(it)
        }
    }


    inner class PersonViewHolder(private val binding: PersonItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(person: Person){
            binding.apply {
                tvEmail.text = person.email
                tvFName.text = person.fName
                tvLName.text = person.lName
                Glide.with(itemView.context)
                    .load(person.avatar)
                    .into(binding.imageAvatar)
            }
        }
    }

    object UserComparator : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id // Compare item ID for uniqueness
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem // Check if contents are the same
        }
    }
}