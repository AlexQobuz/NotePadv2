package fr.alex.notepadv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun onClick(view: View) {
        if (view.tag != null) {
            Log.i("MainActivity", "Click sur une note de la liste !")
        }
    }
}