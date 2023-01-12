package fr.alex.notepadv2

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

    // Affichage de la note
    override fun onClick(view: View) {
        if (view.tag != null) {
            showNoteDetail(view.tag as Int)
        }
    }

    fun showNoteDetail(noteIndex: Int) {
        val note = notes[noteIndex]

        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, noteIndex)
        startActivity(intent)
    }

}