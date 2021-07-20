package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.mobius.ViewEffectConsumer
import com.spotify.mobius.Next
import com.spotify.mobius.Next.next
import com.spotify.mobius.Next.noChange
import com.spotify.mobius.Update

class PetDetailsModelUpdate(private val viewEffectConsumer: ViewEffectConsumer<PetDetailsViewEffect>) :
    Update<PetDetailsModel, PetDetailsEvent, PetDetailsEffect> {

    override fun update(
        model: PetDetailsModel,
        event: PetDetailsEvent
    ): Next<PetDetailsModel, PetDetailsEffect> {
        return when (event) {
            is PetDetailsEvent.OnPetLoaded ->
                next(model.copy(pet = event.pet, viewState = ViewState.LOADED))
            is PetDetailsEvent.LoadPet ->
                next(
                    model.copy(viewState = ViewState.LOADING),
                    setOf(PetDetailsEffect.LoadPet(event.petId))
                )
            PetDetailsEvent.BackPressed -> {
                viewEffectConsumer.accept(PetDetailsViewEffect.CloseScreen)
                noChange()
            }
            PetDetailsEvent.AdoptClicked -> {
                // todo get from model
                viewEffectConsumer.accept(PetDetailsViewEffect.OpenAdoptUrl("https://spca.com"))
                noChange()
            }
            PetDetailsEvent.CallClicked -> {
                // todo get from model
                viewEffectConsumer.accept(PetDetailsViewEffect.OpenAndroidDialer("tel:0821111111"))
                noChange()
            }
        }
    }
}
