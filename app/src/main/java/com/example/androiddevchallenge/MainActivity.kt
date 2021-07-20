/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.details.PetDetailsScreen
import com.example.androiddevchallenge.listing.PetListingViewModel
import com.example.androiddevchallenge.listing.ui.PetListingScreen
import com.example.androiddevchallenge.ui.theme.PetTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                PetAdoptionApp()
            }
        }
    }
}

@Composable
fun PetAdoptionApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = ScreenRoute.PET_LISTING_SCREEN.route) {
        composable(ScreenRoute.PET_LISTING_SCREEN.route) {
            val viewModel: PetListingViewModel = hiltViewModel()
            PetListingScreen(navController, viewModel = viewModel)
        }
        composable(
            ScreenRoute.PET_DETAILS_SCREEN.route,
            arguments = listOf(navArgument("petId") { type = NavType.StringType })
        ) { backStackEntry ->
            PetDetailsScreen(
                navController,
                petId = backStackEntry.arguments?.getString("petId")!!,
                viewModel = hiltViewModel()
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PetTheme {
        PetAdoptionApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PetTheme(darkTheme = true) {
        PetAdoptionApp()
    }
}
