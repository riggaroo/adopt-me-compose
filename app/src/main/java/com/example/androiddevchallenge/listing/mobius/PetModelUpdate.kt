package com.example.androiddevchallenge.listing.mobius

import com.example.androiddevchallenge.listing.PetListModel
import com.example.androiddevchallenge.mobius.ViewEffectConsumer
import com.spotify.mobius.Next
import com.spotify.mobius.Update

/**
 * Main event handling, takes incoming events from background side effects and UI interactions,
 * and transforms the model into a new state.
 */
class PetModelUpdate(val viewEffectConsumer: ViewEffectConsumer<PetListViewEffect>) : Update<PetListModel, PetListEvent, PetListEffect>{

    override fun update(
        model: PetListModel,
        event: PetListEvent
    ): Next<PetListModel, PetListEffect> {
        return when (event){
            is PetListEvent.OnPetSelected ->{
                viewEffectConsumer.accept(PetListViewEffect.ShowPetDetails(event.pet.id))
                Next.noChange()
            }
            is PetListEvent.OnPetsLoaded ->
                Next.next(model.copy(listPets = event.listPets))
        }
    }

}