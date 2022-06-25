package com.onirutla.movflex.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onirutla.movflex.data.source.remote.response.ItemDto
import com.onirutla.movflex.databinding.SeeMoreContainerBinding
import com.onirutla.movflex.ui.SeeMore

class SeeMoreAdapter(
    private inline val itemClickListener: (view: View, itemId: Int) -> Unit,
    private inline val seeMoreClickListener: (view: View, category: String) -> Unit
) : ListAdapter<SeeMore<List<ItemDto>>, SeeMoreAdapter.ViewHolder>(Comparator) {

    private val rvViewPool = RecyclerView.RecycledViewPool()

    object Comparator : DiffUtil.ItemCallback<SeeMore<List<ItemDto>>>() {
        override fun areItemsTheSame(
            oldItem: SeeMore<List<ItemDto>>,
            newItem: SeeMore<List<ItemDto>>
        ): Boolean = oldItem.items == newItem.items

        override fun areContentsTheSame(
            oldItem: SeeMore<List<ItemDto>>,
            newItem: SeeMore<List<ItemDto>>
        ): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        SeeMoreContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: SeeMoreContainerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val itemAdapter by lazy {
            ItemAdapter { view, movie ->
                itemClickListener(view, movie.id)
            }
        }

        init {
            binding.seeAll.setOnClickListener {
                val category = getItem(absoluteAdapterPosition)
                seeMoreClickListener(it, category.title)
            }
        }

        fun bind(seeMore: SeeMore<List<ItemDto>>) {
            binding.seeMore = seeMore
            binding.apply {
                movieGroupingList.apply {
                    adapter = itemAdapter
                    layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    setRecycledViewPool(rvViewPool)
                }
            }
            itemAdapter.submitList(seeMore.items)
        }
    }
}