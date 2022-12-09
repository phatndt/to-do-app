package com.android.presentation.core.widget

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.TextFieldValue
import com.android.presentation.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyDateField(textFieldValue: MutableState<TextFieldValue>) {
    val dialogState = rememberMaterialDialogState()
    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        datepicker {
            val formattedDate = it.format(
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
            )
            textFieldValue.value = TextFieldValue(formattedDate)

        }
    }
    ReadonlyTextField(
        value = textFieldValue.value,
        onValueChange = { textFieldValue.value = it },
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            dialogState.show()
        }
    )
}