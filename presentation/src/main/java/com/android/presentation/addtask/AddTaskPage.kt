package com.android.presentation.addtask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonColors
import androidx.compose.material.Colors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.presentation.R
import com.android.presentation.core.ui.theme.ColorAccent
import com.android.presentation.core.ui.theme.TextStyle
import com.android.presentation.core.ui.theme.ToDoAppTheme
import com.android.presentation.core.widget.MyDateField
import com.android.presentation.core.widget.TimeTextField

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddTaskPage() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(
                vertical = dimensionResource(id = R.dimen.modifier_large_padding),
                horizontal = dimensionResource(
                    id = R.dimen.modifier_medium_padding
                )
            )
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = null,
            tint = ColorAccent,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(
            text = stringResource(R.string.title_add_task),
            style = TextStyle.headlineMedium.copy(color = Color.Black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = dimensionResource(id = R.dimen.modifier_medium_padding))
        )
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.description_add_task),
            style = TextStyle.headlineSmall.copy(color = Color.Black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = dimensionResource(id = R.dimen.modifier_medium_padding)
                )
                .padding(horizontal = dimensionResource(id = R.dimen.modifier_medium_padding))
        )
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_medium_padding)))
        Text(text = "Task title")
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_medium_padding)))
        Text(text = "Task description")
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_medium_padding)))
        Text(text = "Task date")
        MyDateField()
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_medium_padding)))
        Text(text = "Task time")
        TimeTextField()
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_medium_padding)))
        Text(text = "Add an event")
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.modifier_large_padding)))
        ElevatedButton(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.elevatedButtonColors(
                containerColor = colorResource(
                    id = R.color.colorAccent
                )
            ), modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 48.dp)
        ) {
            Text(
                text = "ADD THE TASK",
                textAlign = TextAlign.Center,
                style = TextStyle.headlineSmall,
                color = colorResource(
                    id = R.color.colorPrimary
                )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ToDoAppTheme {
        AddTaskPage()
    }
}
