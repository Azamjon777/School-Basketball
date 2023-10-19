package ganhar.emsfv.schoolbacketball.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ganhar.emsfv.schoolbacketball.databinding.ItemNoteBinding
import ganhar.emsfv.schoolbacketball.model.NoteModel

class NoteAdapter(private val clickListener: OnNoteItemClickListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = listNote[position]
        val binding = holder.binding
        binding.tvTitle.text = currentNote.title
        binding.delete.setOnClickListener {
            clickListener.onNoteItemClick(currentNote)
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNotes(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    interface OnNoteItemClickListener {
        fun onNoteItemClick(noteModel: NoteModel)
    }
}