package com.example.androiddevchallenge

import java.time.ZonedDateTime


data class Pet(
    val id: String,
    val name: String,
    val type: PetType,
    val description: String,
    val imageUrl: String,
    val gender: Gender,
    val weightKg: Float,
    val breed: String,
    // For testing purposes this is just a display string.
    val location: String,
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