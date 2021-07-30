package com.okawa.composepoc.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.okawa.composepoc.ui.theme.ComposePoCTheme

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComposePoCTheme {
        IconButton(
            onClick = onClick,
            modifier = modifier.background(color = MaterialTheme.colors.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Preview
@Composable
fun PreviewButtons() {
    CloseButton(Modifier) {}
}