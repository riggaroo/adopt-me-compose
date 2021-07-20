package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.mobius.MobiusEvent

/**
 * External events coming into the state loop.
 */
sealed class PetDetailsEvent : MobiusEvent {

    data class LoadPet(val petId: String) : PetDetailsEvent()

    data class OnPetLoaded(val pet: Pet) : PetDetailsEvent()

    object BackPressed : PetDetailsEvent()

    object CallClicked : PetDetailsEvent()

    object AdoptClicked : PetDetailsEvent()
}
