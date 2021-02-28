package com.example.androiddevchallenge.listing

import com.example.androiddevchallenge.Pet

data class PetListModel(
    val state: ScreenState = ScreenState.Loading,
    val listPets: List<Pet> = emptyList())

enum class ScreenState {
    Loading,
    Loaded
}