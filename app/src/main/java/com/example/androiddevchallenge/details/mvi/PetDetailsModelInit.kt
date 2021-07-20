package com.example.androiddevchallenge.details.mvi

import com.spotify.mobius.First
import com.spotify.mobius.Init

object PetDetailsModelInit {

    operator fun invoke() = Init<PetDetailsModel, PetDetailsEffect> { model ->
        First.first(model)
    }
}
