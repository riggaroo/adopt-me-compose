package com.example.androiddevchallenge

import java.time.Period
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

fun ZonedDateTime.age() : String {
    val period = Period.between(this.toLocalDate(), ZonedDateTime.now().toLocalDate())
    return period.months.toString() + "months"
}

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