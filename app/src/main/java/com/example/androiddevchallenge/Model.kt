package com.example.androiddevchallenge

import java.time.Period
import java.time.ZonedDateTime


data class Pet(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val gender: Gender,
    val weightKg: Float,
    val breed: String,
    // For testing purposes this is just a display string.
    val location: String,
    val dateOfBirth: ZonedDateTime,
    val label: PetLabel
)

fun ZonedDateTime.age() : String {
    val period = Period.between(this.toLocalDate(), ZonedDateTime.now().toLocalDate())
    return period.months.toString() + " months"
}

enum class PetLabel {
    Puppy,
    Adult
}

enum class Gender {
    Male,
    Female,
    NotSpecified
}