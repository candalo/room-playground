package com.github.roomplayground.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.roomplayground.R
import com.github.roomplayground.data.DaggerNotesComponent
import com.github.roomplayground.domain.Note
import javax.inject.Inject

class NotesActivity : AppCompatActivity(), NotesView {

    @Inject
    lateinit var presenter: NotesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        injectDependencies()
        setupPresenter()
    }

    private fun injectDependencies() {
        DaggerNotesComponent.create().inject(this)
    }

    private fun setupPresenter() {
        presenter.attachTo(this)
    }

    override fun showNotes(notes: List<Note>) {

    }

    override fun openNote(note: Note) {

    }
}
