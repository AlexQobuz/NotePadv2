package fr.alex.notepadv2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Afficher la toolbar attention à bien utiliser androidx dans l'import
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        findViewById(R.id.create_note_fab).setOnClickListener(this)

        notes = mutableListOf<Note>()
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))
        notes.add(Note("Alexandre", "Aller chercher les enfants"))

        adapter = NoteAdapter(notes, this)

        val recyclerView = findViewById(R.id.notes_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK || data == null) {
            return
        }

        when (requestCode) {
            NoteDetailActivity.REQUEST_EDIT_NOTE -> processEditNoteResult(data)
        }
    }

    private fun processEditNoteResult(data: Intent) {
        val noteIndex = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)
        val  note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
        saveNote(note, noteIndex)
    }

    private fun saveNote(note: Note?, noteIndex: Int) {
        if (noteIndex < 0) {
            if (note != null) {
                notes.add(0, note)
            }
        } else {
            if (note != null) {
                notes[noteIndex] = note
            }

        }
        adapter.notifyDataSetChanged()
    }

    // Affichage de la note
    override fun onClick(view: View) {
        if (view.tag != null) {
            showNoteDetail(view.tag as Int)
        } else {
            when(view.id) {
                R.id.create_note_fab -> createNote()
            }
        }
    }

    fun createNote() {
        showNoteDetail(-1)
    }

    fun showNoteDetail(noteIndex: Int) {
        val note = notes[noteIndex]

        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, noteIndex)
        startActivityForResult(intent, NoteDetailActivity.REQUEST_EDIT_NOTE)
    }

}