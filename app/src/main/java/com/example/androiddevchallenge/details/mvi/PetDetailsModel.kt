package com.example.androiddevchallenge.details.mvi

import com.example.androiddevchallenge.Pet

data class PetDetailsModel(
    val viewState: ViewState = ViewState.LOADING,
    val pet: Pet? = null
)

enum class ViewState {
    LOADING,
    LOADED
}
