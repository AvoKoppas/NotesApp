package com.testdevlab.notesapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.testdevlab.notesapp.databinding.ItemNoteBinding
import com.testdevlab.notesapp.repository.models.NoteItem
import kotlin.properties.Delegates

class NoteListAdapter(private val onItemClick: (noteItem: NoteItem) -> Unit) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var noteList: List<NoteItem> by Delegates.observable(emptyList(), { _, old, new ->
        DiffUtil.calculateDiff(DifferenceUtil(old, new)).dispatchUpdatesTo(this)
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NoteListAdapter.ViewHolder, position: Int) {
        val item = noteList[position]
        holder.binding.noteItem.tag = item
        holder.binding.item = item

        holder.binding.noteItem.setOnClickListener { cardView ->
            onItemClick(cardView.tag as NoteItem)
        }
    }

    override fun getItemCount() = noteList.size
    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)
    inner class DifferenceUtil(private val old: List<NoteItem>, private val new: List<NoteItem>) : DiffUtil.Callback() {
        override fun getOldListSize() = old.size
        override fun getNewListSize() = new.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition].text == new[newItemPosition].text
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition] == new[newItemPosition]
    }
}

