package com.example.androiddevchallenge

sealed class Screen(val route: ScreenRoute) {

    abstract fun getCalculatedRoute(): String

    object PetListingScreen: Screen(ScreenRoute.PET_LISTING_SCREEN) {
        override fun getCalculatedRoute(): String {
            return route.route
        }
    }
    // TODO Think of a generic way to construct calculated routes.
    data class PetDetailsScreen(val petId: String): Screen(ScreenRoute.PET_DETAILS_SCREEN) {
        override fun getCalculatedRoute(): String {
            return "/details/$petId"
        }
    }
}

enum class ScreenRoute(val route: String) {
    PET_LISTING_SCREEN("/list"),
    PET_DETAILS_SCREEN("/details/{petId}")
}