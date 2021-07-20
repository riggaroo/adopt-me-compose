package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.mobius.MobiusEffect

sealed class PetDetailsEffect : MobiusEffect {

    data class LoadPet(val petId: String) : PetDetailsEffect()
}
