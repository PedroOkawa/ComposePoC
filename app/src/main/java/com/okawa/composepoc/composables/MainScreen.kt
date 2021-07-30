package com.okawa.composepoc.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.okawa.composepoc.MainActivityViewModel
import com.okawa.composepoc.MainActivityViewModel.UiEvent.*
import com.okawa.composepoc.ui.theme.ComposePoCTheme

private const val TAB_LIVE = "Live"
private const val TAB_SCHEDULE = "Schedule"
private val TABS = listOf(TAB_LIVE, TAB_SCHEDULE)

@Composable
fun MainScreen(
    viewModel: MainActivityViewModel = viewModel(),
    onClose: () -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navController = rememberNavController()

    viewModel.uiEvent.observe(lifecycleOwner) { uiEvent ->
        when (uiEvent) {
            Close -> onClose()
            GoToLive -> navController.navigate(CreateMediaConstants.DESTINATION)
            GoToSchedule -> navController.navigate(ScheduleMediaConstants.DESTINATION)
        }
    }

    ComposePoCTheme {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (navHost, tabLayout) = createRefs()
            val navHostModifier = Modifier
            val tabLayoutModifier = Modifier

            NavHost(
                modifier = navHostModifier.constrainAs(navHost) {
                    top.linkTo(parent.top)
                    bottom.linkTo(tabLayout.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
                navController = navController,
                startDestination = CreateMediaConstants.DESTINATION
            ) {
                composable(CreateMediaConstants.DESTINATION) { CreateMedia(modifier = navHostModifier) { viewModel.close() } }
                composable(ScheduleMediaConstants.DESTINATION) { ScheduleMedia(modifier = navHostModifier) { viewModel.close() } }
            }

            TabLayout(
                modifier = tabLayoutModifier.background(MaterialTheme.colors.surface).constrainAs(tabLayout) {
                    top.linkTo(navHost.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                tabOptions = TABS
            ) { tab ->
                when (tab) {
                    TAB_LIVE -> viewModel.openLive()
                    TAB_SCHEDULE -> viewModel.openSchedule()
                }
            }
        }
    }
}