package com.okawa.composepoc

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.okawa.composepoc.composables.MainScreen
import com.okawa.composepoc.di.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

private const val REQUIRED_PERMISSIONS = Manifest.permission.CAMERA

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MainActivityViewModel> { viewModelFactory }

    private val permReqLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                setupContentView()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        permReqLauncher.launch(REQUIRED_PERMISSIONS)
    }

    private fun setupContentView() {
        setContent {
            MainScreen(viewModel = viewModel) { finish() }
        }
    }
}