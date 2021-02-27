package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetGrid(pets: List<Pet>){
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        content = {
            items(pets.size) { index ->
                PetCardListItem(pet = pets[index])
            }
        })
}