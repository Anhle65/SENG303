package nz.ac.canterbury.seng303.lab2.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EditNoteViewModel: ViewModel() {
    var title by mutableStateOf("")
        private set
    fun updateTitle(newTitle: String) {
        title = newTitle
    }

    var content by mutableStateOf("")
        private set

    fun updateContent(newContent: String) {
        content = newContent
    }

    var isArchived by mutableStateOf(false)
        private set

    fun updateArchived(newState: Boolean) {
        isArchived = newState;
    }
}