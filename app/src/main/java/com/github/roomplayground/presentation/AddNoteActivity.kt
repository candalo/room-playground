package com.github.roomplayground.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.roomplayground.MyApplication
import com.github.roomplayground.R
import com.github.roomplayground.data.di.DaggerAddNoteComponent
import com.github.roomplayground.domain.Note
import kotlinx.android.synthetic.main.activity_add_note.ed_note as noteEditText
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity(), AddNoteView {

    @Inject
    lateinit var presenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        injectDependencies()
        setupToolbar()
        setupPresenter()
    }

    private fun injectDependencies() {
        val appComponent = (application as MyApplication).getAppComponent()
        DaggerAddNoteComponent.builder().appComponent(appComponent).build().inject(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.add_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setupPresenter() {
        presenter.attachTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_save_note -> {
                presenter.onSaveNoteOptionSelected(noteEditText.text.toString())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNoteSaved(note: Note) {
        finish()
    }
}
