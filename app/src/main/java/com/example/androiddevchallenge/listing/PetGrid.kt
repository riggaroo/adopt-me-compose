package com.example.androiddevchallenge.listing

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.Pet

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetGrid(modifier: Modifier, pets: List<Pet>, onPetClick: (Pet) -> Unit){
    LazyVerticalGrid(modifier = modifier,
        cells = GridCells.Fixed(2),
        content = {

            items(pets.size) { index ->
                PetCardListItem(pet = pets[index], onPetClick = onPetClick)
            }
        },)
}