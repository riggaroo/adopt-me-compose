package com.example.androiddevchallenge

sealed class Screen(val route: String) {
    object PetListingScreen: Screen("/list")
    object PetDetailsScreen: Screen("/details/{petId}")
}