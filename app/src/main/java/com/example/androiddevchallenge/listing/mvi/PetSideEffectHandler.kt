package com.example.androiddevchallenge.listing.mvi

import com.example.androiddevchallenge.usecase.PetUseCase
import com.spotify.mobius.rx3.RxMobius
import io.reactivex.rxjava3.core.ObservableTransformer

/**
 * Side effects are for long running async operations (ie fetching stuff from the internet or from a file).
 */
object PetSideEffectHandler {

    operator fun invoke(petUseCase: PetUseCase): ObservableTransformer<PetListEffect, PetListEvent> {
        val effectHandlerBuilder =
            RxMobius.subtypeEffectHandler<PetListEffect, PetListEvent>()

        effectHandlerBuilder.addTransformer(
            PetListEffect.LoadPets::class.java,
            loadPets(petUseCase = petUseCase)
        )
        return effectHandlerBuilder.build()
    }

    private fun loadPets(petUseCase: PetUseCase) = ObservableTransformer<PetListEffect.LoadPets, PetListEvent> { upstream ->
        upstream.flatMap {
            petUseCase.getPets()
                .toObservable()
                .map {
                    PetListEvent.OnPetsLoaded(it)
                }
        }
    }
}
