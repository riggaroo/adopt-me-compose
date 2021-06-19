package com.example.androiddevchallenge.usecase

import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.data.PetRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class PetUseCase @Inject constructor(val petRepository: PetRepository) {

    fun getPets(): Flowable<List<Pet>> {
        return petRepository.getListPets().toFlowable()
    }
}
