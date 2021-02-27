package com.example.androiddevchallenge

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.androiddevchallenge.details.PetDetailsViewModel

@Composable
fun PetDetailsScreen(navController: NavController, petId: String, viewModel: PetDetailsViewModel) {
    viewModel.loadPetInfo(petId = petId)
    val pet = viewModel.petData.observeAsState()
    if (pet.value != null){
        Text(text = pet.value!!.name)
    } else {
        CircularProgressIndicator()
    }
}