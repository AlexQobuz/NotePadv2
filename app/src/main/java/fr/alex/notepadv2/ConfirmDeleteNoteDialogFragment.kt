package fr.alex.notepadv2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment


class ConfirmDeleteNoteDialogFragment(val noteTitle : String = "") : DialogFragment() {

    interface ConfrimDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    val listener: ConfrimDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)

        builder.setMessage("Etes-vous sûre de vouloir supprimer la note \'$noteTitle\' ?")
            .setPositiveButton("Supprimer",
                DialogInterface.OnClickListener{ dialog, id -> listener?.onDialogPositiveClick() })
            .setNegativeButton("Supprimer",
                DialogInterface.OnClickListener{ dialog, id -> listener?.onDialogNegativeClick() })

        return builder.create()

    }

}