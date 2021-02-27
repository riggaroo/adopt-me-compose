package com.example.androiddevchallenge

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androiddevchallenge.details.PetDetailsViewModel

@Composable
fun PetDetailsScreen(navController: NavController, viewModel: PetDetailsViewModel) {
    Text(text = "pet detail")
}