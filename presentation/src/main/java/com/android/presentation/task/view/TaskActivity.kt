package com.android.presentation.task.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.presentation.R
import com.android.presentation.addtask.AddTaskPage
import com.android.presentation.core.ui.theme.ColorAccent
import com.android.presentation.core.ui.theme.TextStyle
import com.android.presentation.core.ui.theme.ToDoAppTheme
import kotlinx.coroutines.launch

class TaskActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskMain()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun TaskMain() {
    val scaffoldState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = scaffoldState,
        sheetContent = {
            AddTaskPage()
        },
        sheetBackgroundColor = Color.White,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.modifier_medium_padding))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.modifier_large_padding))
            ) {
                Column {
                    Text(text = stringResource(R.string.hello), style = TextStyle.headlineSmall)
                    Text(
                        text = stringResource(R.string.all_tasks),
                        style = TextStyle.headlineLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier.size(size = dimensionResource(id = R.dimen.modifier_larger_padding))
                    )
                }
            }
            TaskWidget()
            Scaffold(modifier = Modifier.weight(1f)) {

            }
            ElevatedButton(
                onClick = {
                    scope.launch {
                        if (scaffoldState.isVisible) {
                            scaffoldState.hide()
                        } else {
                            scaffoldState.animateTo(
                                ModalBottomSheetValue.Expanded
                            )
                        }
                    }
                },
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.5.dp),
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.modifier_large_padding))
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    tint = ColorAccent,
                    modifier = Modifier.padding(all = dimensionResource(id = R.dimen.modifier_mini_padding))
                )
                Text(text = "Add Task", style = TextStyle.headlineMedium)
            }
        }
    }


    BackHandler {
        scope.launch {
            if (scaffoldState.isVisible) {
                scaffoldState.hide()
            }
        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ToDoAppTheme {
        TaskMain()
    }
}

