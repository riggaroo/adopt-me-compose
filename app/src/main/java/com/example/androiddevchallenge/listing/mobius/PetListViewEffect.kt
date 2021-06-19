package com.example.androiddevchallenge.listing.mobius

/**
 * View related once off effects that need to happen, ie navigate to a new screen. Show a toast etc.
 */
sealed class PetListViewEffect {
    data class ShowPetDetails(val petId: String) : PetListViewEffect()
}
