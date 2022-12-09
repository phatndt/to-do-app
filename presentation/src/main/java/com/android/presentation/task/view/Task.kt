package com.android.presentation.task.view

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.presentation.core.ui.theme.TextStyle
import com.android.presentation.core.ui.theme.ToDoAppTheme
import com.android.presentation.R

@Composable
fun TaskWidget() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp), modifier = Modifier
                .height(128.dp)
                .fillMaxWidth()
        ) {
            Row() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier =
                    Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = dimensionResource(id = R.dimen.modifier_small_padding))
                ) {
                    Text("Wed", style = TextStyle.headlineMediumLarge.copy(color = Color.Gray))
                    Text(
                        "09",
                        style = TextStyle.headlineMediumLarge.copy(color = colorResource(id = R.color.colorAccent))
                    )
                    Text("Dec", style = TextStyle.headlineMediumLarge.copy(color = Color.Gray))
                }
                Divider(
                    thickness = 1.dp, color = Color.Gray, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.modifier_small_padding),
                            vertical = dimensionResource(
                                id = R.dimen.modifier_medium_small_padding
                            )
                        )
                ) {
                    Text(
                        "Video",
                        style = TextStyle.headlineMediumLarge.copy(fontWeight = FontWeight.Bold),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        "Edit video for english center",
                        style = TextStyle.headlineSmall.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        ),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        "20:00",
                        style = TextStyle.headlineSmall.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "UPCOMING",
                        style = TextStyle.headlineSmall.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .padding(
                            top = dimensionResource(
                                id = R.dimen.modifier_medium_small_padding
                            ), end = dimensionResource(
                                id = R.dimen.modifier_smaller_padding
                            )
                        )
                        .size(24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskWidgetPreview() {
    ToDoAppTheme {
        TaskWidget()
    }
}