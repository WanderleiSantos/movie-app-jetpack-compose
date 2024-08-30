package com.wanderlei.movieapp.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.wanderlei.movieapp.core.presentation.navigation.BottomNavigationBar
import com.wanderlei.movieapp.core.presentation.navigation.DetailScreenNav
import com.wanderlei.movieapp.core.presentation.navigation.NavigationGraph
import com.wanderlei.movieapp.core.presentation.navigation.currentRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            if (currentRoute(navController = navController) != DetailScreenNav.DetailScreen.route) {
                BottomNavigationBar(navController = navController)
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                NavigationGraph(navController = navController)
            }

        }
    )
}