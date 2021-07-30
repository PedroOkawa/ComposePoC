package com.okawa.composepoc.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.okawa.composepoc.ui.theme.ComposePoCTheme

object ScheduleMediaConstants {
    const val DESTINATION = "ScheduleMedia"
}

@Composable
fun ScheduleMedia(
    modifier: Modifier = Modifier,
    onCloseButton: () -> Unit
) {
    ComposePoCTheme {
        ConstraintLayout(
            modifier = modifier.fillMaxSize().background(MaterialTheme.colors.surface)
        ) {
            val buttonRef = createRef()

            CloseButton(modifier = modifier.constrainAs(buttonRef) {
                top.linkTo(anchor = parent.top, margin = 16.dp)
                start.linkTo(anchor = parent.start, margin = 16.dp)
            }) {
                onCloseButton()
            }
        }
    }
}