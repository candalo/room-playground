package com.github.roomplayground.presentation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.github.roomplayground.MyApplication
import com.github.roomplayground.R
import com.github.roomplayground.data.di.DaggerNotesComponent
import com.github.roomplayground.domain.Note
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_notes.rv_notes as notesRecyclerView
import kotlinx.android.synthetic.main.activity_notes.fab_add_note as addNoteFab
import kotlinx.android.synthetic.main.activity_notes.view_notes_empty as notesEmptyView
import javax.inject.Inject

class NotesActivity : AppCompatActivity(), NotesView {

    @Inject
    lateinit var presenter: NotesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        injectDependencies()
        setupToolbar()
        setupPresenter()
        setupFabButton()
    }

    private fun injectDependencies() {
        val appComponent = (application as MyApplication).getAppComponent()
        DaggerNotesComponent.builder().appComponent(appComponent).build().inject(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.notes)
    }

    private fun setupPresenter() {
        presenter.attachTo(this)
    }

    private fun setupFabButton() {
        addNoteFab.setOnClickListener(fabButtonClickListener)
    }

    private val fabButtonClickListener = View.OnClickListener {
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    override fun showEmptyNotesInfo() {
        notesEmptyView.visibility = View.VISIBLE
    }

    override fun hideEmptyNotesInfo() {
        notesEmptyView.visibility = View.INVISIBLE
    }

    override fun showNotes(notes: List<Note>) {
        notesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@NotesActivity, 2)
            adapter = NotesAdapter(notes)
        }
    }

    override fun openNote(note: Note) {

    }
}
