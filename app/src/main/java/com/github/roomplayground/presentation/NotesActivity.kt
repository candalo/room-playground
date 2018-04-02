package com.github.roomplayground.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.roomplayground.MyApplication
import com.github.roomplayground.R
import com.github.roomplayground.data.di.DaggerNotesComponent
import com.github.roomplayground.domain.Note
import kotlinx.android.synthetic.main.activity_notes.view_notes_empty as notesEmptyView
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
        val appComponent = (application as MyApplication).getAppComponent()
        DaggerNotesComponent.builder().appComponent(appComponent).build().inject(this)
    }

    private fun setupPresenter() {
        presenter.attachTo(this)
    }

    override fun showEmptyNotesInfo() {
        notesEmptyView.visibility = View.VISIBLE
    }

    override fun hideEmptyNotesInfo() {
        notesEmptyView.visibility = View.INVISIBLE
    }

    override fun showNotes(notes: List<Note>) {

    }

    override fun openNote(note: Note) {

    }
}
