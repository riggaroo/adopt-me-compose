package com.example.androiddevchallenge.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PetDetailsScreen(navController: NavController, petId: String, viewModel: PetDetailsViewModel) {
    viewModel.loadPetInfo(petId = petId)
    val pet = viewModel.petData.observeAsState()
    if (pet.value != null) {
        TopAppBar(
            title = { Text(text = pet.value!!.name,
            style = MaterialTheme.typography.h5) },
            navigationIcon = {
                Icon(Icons.Filled.ArrowBack, "back",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                        .padding(12.dp))
            },
            modifier = Modifier.height(56.dp)
        )

    } else {
        CircularProgressIndicator()
    }
}
