/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

sealed class Screen(val route: ScreenRoute) {

    abstract fun getCalculatedRoute(): String

    object PetListingScreen : Screen(ScreenRoute.PET_LISTING_SCREEN) {
        override fun getCalculatedRoute(): String {
            return route.route
        }
    }
    // TODO Think of a generic way to construct calculated routes.
    data class PetDetailsScreen(val petId: String) : Screen(ScreenRoute.PET_DETAILS_SCREEN) {
        override fun getCalculatedRoute(): String {
            return "/details/$petId"
        }
    }
}

enum class ScreenRoute(val route: String) {
    PET_LISTING_SCREEN("/list"),
    PET_DETAILS_SCREEN("/details/{petId}")
}
