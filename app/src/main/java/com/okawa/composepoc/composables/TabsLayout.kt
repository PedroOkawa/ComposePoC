package com.okawa.composepoc.composables

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TabLayout(
    modifier: Modifier = Modifier,
    tabOptions: List<String>,
    onTabSelected: (String) -> Unit
) {
    var tabIndex by remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = modifier
    ) {
        tabOptions.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
                onTabSelected(text)
            }, text = {
                Text(text = text)
            })
        }
    }
}

