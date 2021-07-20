package com.example.androiddevchallenge.listing.mvi

/**
 * Side Effects
 */
sealed class PetListEffect {

    object LoadPets : PetListEffect()
}
