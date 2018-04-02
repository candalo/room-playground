package com.github.roomplayground.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.roomplayground.R
import com.github.roomplayground.domain.Note


class NotesAdapter(
        private val notes: MutableList<Note>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    fun addNote(note: Note) {
        notes.add(note)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTextView.text = note.text
    }

    inner class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteTextView: TextView = view.findViewById(R.id.tv_note)
        val noteDateTextView: TextView = view.findViewById(R.id.tv_note_date)
    }
}