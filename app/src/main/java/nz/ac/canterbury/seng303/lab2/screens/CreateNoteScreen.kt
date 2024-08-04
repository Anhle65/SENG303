package nz.ac.canterbury.seng303.lab2.screens

import android.app.AlertDialog
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import nz.ac.canterbury.seng303.lab2.models.Note
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNote(navController: NavController, title: String,
               onTitleChange: (String) -> Unit,
               content: String, onContentChange: (String) -> Unit,
               createNoteFn: (String, String) -> Unit
) {
    val context = LocalContext.current
//    var title by rememberSaveable { mutableStateOf("") }
//    var content by rememberSaveable { mutableStateOf("") }
//    val createNoteViewModel: CreateNoteViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = {onTitleChange(it)},
            label = { Text("Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Content input
        OutlinedTextField(
            value = content,
            onValueChange = {onContentChange(it)},
            label = { Text("Content") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .fillMaxHeight()
                .weight(1f)
        )

        // Save button
        Button(
            onClick = {
//                val note = Note(Random.nextInt(0, Int.MAX_VALUE),
//                    title,
//                    content,
//                    System.currentTimeMillis(),
//                    false)
                createNoteFn(title, content)
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Created note: ")
                    .setCancelable(false)
                    .setPositiveButton("Ok") { dialog, id -> /* Run some code on click */
                        onTitleChange("")
                        onContentChange("")
                        navController.navigate("noteList")

                    }
                    .setNegativeButton("Cancel") { dialog, id ->
                        // Dismiss the dialog
                        dialog.dismiss()
                    }
                val alert = builder.create()
                alert.show()

            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Save")
        }
    }
}
