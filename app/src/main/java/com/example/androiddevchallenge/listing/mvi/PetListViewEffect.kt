package com.example.androiddevchallenge.listing.mvi

import com.example.androiddevchallenge.mobius.MobiusViewEffect

/**
 * View related once off effects that need to happen, ie navigate to a new screen. Show a toast etc.
 */
sealed class PetListViewEffect : MobiusViewEffect {
    data class ShowPetDetails(val petId: String) : PetListViewEffect()
}
