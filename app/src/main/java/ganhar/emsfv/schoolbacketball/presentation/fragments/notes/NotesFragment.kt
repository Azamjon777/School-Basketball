package ganhar.emsfv.schoolbacketball.presentation.fragments.notes

import android.app.AlertDialog
import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ganhar.emsfv.schoolbacketball.adapter.NoteAdapter
import ganhar.emsfv.schoolbacketball.databinding.DialogAddNoteBinding
import ganhar.emsfv.schoolbacketball.databinding.FragmentNotesBinding
import ganhar.emsfv.schoolbacketball.model.NoteModel
import ganhar.emsfv.schoolbacketball.viewmodel.StartViewModel
import ganhar.emsfv.schoolbacketball.viewmodel.StartViewModelFactory

class NotesFragment : Fragment(), NoteAdapter.OnNoteItemClickListener {
    private lateinit var binding: FragmentNotesBinding
    private val viewModel: StartViewModel by lazy {
        ViewModelProvider(
            this,
            StartViewModelFactory(requireContext().applicationContext as Application)
        )[StartViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NoteAdapter(this)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.initDatabase()
        viewModel.getAllNotes().observe(viewLifecycleOwner) { notes ->
            notes?.let { adapter.setNotes(it) }
        }

        binding.addButton.setOnClickListener {
            showAddNoteDialog()
        }
    }

    override fun onNoteItemClick(noteModel: NoteModel) {
        val action = NotesFragmentDirections.actionNotesFragmentToNoteDetailFragment(noteModel)
        findNavController().navigate(action)
    }

    private fun showAddNoteDialog() {
        val binding = DialogAddNoteBinding.inflate(layoutInflater)
        val tvTitle = binding.etTitle
        val tvDesc = binding.etDesc

        val dialog = AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("ОК") { dialog, _ ->
                val title = tvTitle.text.toString()
                val desc = tvDesc.text.toString()
                val newNote = NoteModel(title = title, desc = desc)
                viewModel.insert(newNote) {
                    viewModel.insert(newNote) {}
                }
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }

}
