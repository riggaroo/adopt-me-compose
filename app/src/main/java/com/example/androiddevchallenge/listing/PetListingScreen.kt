package com.example.androiddevchallenge.listing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen

@Composable
fun PetListingScreen(navController: NavController, viewModel: PetListingViewModel) {
    val pets = viewModel.petsData.observeAsState(emptyList())
    Surface(color = MaterialTheme.colors.background) {
        Column() {
            Text(text = stringResource(id = R.string.pet_adopt_title),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(start = 16.dp,
                    end = 16.dp,
                    top = 32.dp,
                    bottom = 8.dp))
            PetGrid(modifier = Modifier.padding(start = 12.dp,
                end = 12.dp),
                pets.value
            ) { pet ->
                navController.navigate(Screen.PetDetailsScreen(pet.id).getCalculatedRoute())
            }
        }
    }
}