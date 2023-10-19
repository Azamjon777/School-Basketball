package ganhar.emsfv.schoolbacketball.db.repository

import androidx.lifecycle.LiveData
import ganhar.emsfv.schoolbacketball.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
}