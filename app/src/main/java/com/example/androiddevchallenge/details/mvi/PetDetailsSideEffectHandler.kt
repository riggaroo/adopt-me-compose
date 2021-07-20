package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.usecase.PetUseCase
import com.spotify.mobius.rx3.RxMobius
import io.reactivex.rxjava3.core.ObservableTransformer

object PetDetailsSideEffectHandler {

    operator fun invoke(petUseCase: PetUseCase): ObservableTransformer<PetDetailsEffect, PetDetailsEvent> {
        val effectHandlerBuilder =
            RxMobius.subtypeEffectHandler<PetDetailsEffect, PetDetailsEvent>()

        effectHandlerBuilder.addTransformer(
            PetDetailsEffect.LoadPet::class.java,
            loadPet(petUseCase = petUseCase)
        )
        return effectHandlerBuilder.build()
    }

    private fun loadPet(petUseCase: PetUseCase) = ObservableTransformer<PetDetailsEffect.LoadPet, PetDetailsEvent> { upstream ->
        upstream.flatMap { effect ->
            petUseCase.getPet(effect.petId)
                .toObservable()
                .map { pet ->
                    PetDetailsEvent.OnPetLoaded(pet)
                }
        }
    }
}
