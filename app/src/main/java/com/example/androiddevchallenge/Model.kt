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

// TODO Improve this age calculation, take into account localisation as well as more options like days.
fun ZonedDateTime.age(): String {
    val period = Period.between(this.toLocalDate(), ZonedDateTime.now().toLocalDate())
    if (period.years > 0){
        return period.years.toString() + " years"
    }
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
