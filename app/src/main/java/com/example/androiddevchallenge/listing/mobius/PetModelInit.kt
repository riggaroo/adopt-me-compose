package com.example.androiddevchallenge.listing.mobius

import com.example.androiddevchallenge.listing.PetListModel
import com.spotify.mobius.First
import com.spotify.mobius.Init

object PetModelInit {

    operator fun invoke() = Init<PetListModel, PetListEffect> { model ->
        First.first(model, setOf(PetListEffect.LoadPets))
    }
}
