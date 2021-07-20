package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.mobius.MobiusViewEffect

sealed class PetDetailsViewEffect : MobiusViewEffect {

    data class OpenAndroidDialer(val phoneNumber: String) : PetDetailsViewEffect()

    data class OpenAdoptUrl(val url: String) : PetDetailsViewEffect()

    object CloseScreen : PetDetailsViewEffect()
}
