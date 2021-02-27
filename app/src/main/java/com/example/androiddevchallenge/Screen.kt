package com.example.androiddevchallenge

sealed class Screen(val route: String) {
    object PetListingScreen: Screen("/details")
    object PetDetailsScreen: Screen("/list")
}