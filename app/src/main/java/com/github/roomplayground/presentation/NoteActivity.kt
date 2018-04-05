package com.github.roomplayground.presentation

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.roomplayground.MyApplication
import com.github.roomplayground.R
import com.github.roomplayground.data.di.DaggerNoteComponent
import com.github.roomplayground.domain.Note
import com.github.roomplayground.util.DateUtil
import kotlinx.android.synthetic.main.activity_add_note.ed_note as noteEditText
import kotlinx.android.synthetic.main.toolbar.*
import org.parceler.Parcels
import java.util.Date
import javax.inject.Inject

class NoteActivity : AppCompatActivity(), NoteView {

    @Inject
    lateinit var presenter: NotePresenter
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        note = getNote()
        setupNote()
        injectDependencies()
        setupToolbar()
        setupPresenter()
    }

    private fun getNote(): Note? = Parcels.unwrap(intent.getParcelableExtra(Note::javaClass.name))

    private fun setupNote() {
        noteEditText.setText(note?.text ?: "")
    }

    private fun injectDependencies() {
        val appComponent = (application as MyApplication).getAppComponent()
        DaggerNoteComponent.builder().appComponent(appComponent).build().inject(this)
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
                val note = Note(note?.id ?: 0, noteEditText.text.toString(), DateUtil.getDateInFull(Date()))
                presenter.onSaveNoteOptionSelected(note, isUpdate())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isUpdate(): Boolean = note != null

    override fun onNoteSaved(note: Note) {
        val intent = Intent()
        intent.putExtra(Note::javaClass.name, Parcels.wrap(note))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
