package com.example.androiddevchallenge.listing.mobius

import com.example.androiddevchallenge.Pet

/**
 * External events coming into the state loop.
 */
sealed class PetListEvent {
    data class OnPetsLoaded(val listPets: List<Pet>): PetListEvent()

    data class OnPetSelected(val pet: Pet): PetListEvent()
}