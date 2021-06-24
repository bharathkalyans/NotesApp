package com.bharathkalyans.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bharathkalyans.notesapp.data.Note
import kotlinx.android.synthetic.main.custom_row.view.*

class NoteAdapter(private val context: Context, private val listener: INotesRVAdapter) :
    RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    private var notes = ArrayList<Note>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /* val inputTextNote = itemView.findViewById<TextView>(R.id.etInputNote)
         val deleteButton = itemView.findViewById<ImageView>(R.id.btnDeleteNote)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder =
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_row, parent, false))

        /*viewHolder.deleteButton.setOnClickListener {
            listener.onItemClicked(notes[viewHolder.adapterPosition])
        }*/

        viewHolder.itemView.btnDeleteNote.setOnClickListener {
            listener.onItemClicked(notes[viewHolder.adapterPosition])

        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        holder.inputTextNote.text = notes[position].text
        holder.itemView.text.text = notes[position].text

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun updateList(newList: List<Note>) {

        notes.clear()
        notes.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter {
    fun onItemClicked(note: Note)
}