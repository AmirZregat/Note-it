package com.project.noteit.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.noteit.data.model.Note
import com.project.noteit.databinding.ItemNoteLayoutBinding
import java.text.SimpleDateFormat

class NoteListingAdapter(
    val onItemClicked: (Int, Note) -> Unit,
    val onEditClicked: (Int, Note) -> Unit,
    val onDeleteClicked: (Int,Note) -> Unit
) : RecyclerView.Adapter<NoteListingAdapter.MyViewHolder>() {

    private var list: MutableList<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemNoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateList(list: MutableList<Note>){
        this.list = list
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        list.removeAt(position)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: ItemNoteLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Note){
            binding.noteIdValue.setText(item.id)
            binding.msg.setText(item.text)
            binding.edit.setOnClickListener { onEditClicked.invoke(adapterPosition,item) }
            binding.delete.setOnClickListener { onDeleteClicked.invoke(adapterPosition,item) }
            binding.itemLayout.setOnClickListener { onItemClicked.invoke(adapterPosition,item) }
        }
    }
}