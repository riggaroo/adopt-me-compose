package com.example.androiddevchallenge

import java.time.ZonedDateTime


data class Pet(
    val id: String,
    val name: String,
    val type: PetType,
    val imageUrl: String,
    val gender: Gender,
    val weightKg: Float,
    val breed: String,
    val location: LongLatLocation,
    val dateOfBirth: ZonedDateTime
)

enum class PetType {
    Dog,
    Cat,
    Bunny
}

enum class Gender {
    Male,
    Female,
    NotSpecified
}

data class LongLatLocation(
    val longitude: Float,
    val latitude: Float
)