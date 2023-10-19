package ganhar.emsfv.schoolbacketball.presentation.fragments.notes

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ganhar.emsfv.schoolbacketball.databinding.FragmentNoteDetailBinding
import ganhar.emsfv.schoolbacketball.model.NoteModel
import ganhar.emsfv.schoolbacketball.viewmodel.StartViewModel
import ganhar.emsfv.schoolbacketball.viewmodel.StartViewModelFactory

class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding
    private val viewModel: StartViewModel by lazy {
        ViewModelProvider(
            this,
            StartViewModelFactory(requireContext().applicationContext as Application)
        )[StartViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noteModel = arguments?.getSerializable("noteModel") as? NoteModel

        binding.etTitle.setText(noteModel?.title)
        binding.etDesc.setText(noteModel?.desc)

        binding.save.setOnClickListener {
            if (noteModel != null) {
                viewModel.insert(noteModel) {}
            }
        }
        binding.delete.setOnClickListener {
            if (noteModel != null) {
                viewModel.delete(noteModel) {}
            }
        }
    }
}
