package com.okawa.composepoc.composables

import android.view.Surface
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.okawa.composepoc.ui.theme.ComposePoCTheme

object CreateMediaConstants {
    const val DESTINATION = "CreateMedia"
}

@Composable
fun CreateMedia(
    modifier: Modifier = Modifier,
    onCloseButton: () -> Unit
) {
    ComposePoCTheme {
        ConstraintLayout(modifier = modifier) {
            val imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setTargetRotation(Surface.ROTATION_0)
                .build()
            val buttonRef = createRef()

            CameraPreview(
                modifier = Modifier.fillMaxSize(),
                imageCapture = imageCapture
            )

            CloseButton(modifier = Modifier.constrainAs(buttonRef) {
                top.linkTo(anchor = parent.top, margin = 16.dp)
                start.linkTo(anchor = parent.start, margin = 16.dp)
            }) {
                onCloseButton()
            }
        }
    }
}