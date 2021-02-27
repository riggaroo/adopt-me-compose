package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.Gender
import com.example.androiddevchallenge.Pet
import com.example.androiddevchallenge.PetType
import java.time.ZoneId
import java.time.ZonedDateTime

class PetRepository {
    private val listOfPets = listOf(dog, dog3, pickle)

    suspend fun getListPets(): List<Pet>
    {
        // FIXME IRL this would come from a server
        return listOfPets
    }

    suspend fun getPetById(id: String): Pet? {
        return listOfPets.find { it.id == id }
    }
}

val dog = Pet(
    "1",
    "Basil",
    PetType.Dog,
    "Basil is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1518378188025-22bd89516ee2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    Gender.Male,
    2.2f,
    "Cross",
    "110 N 3th St, Brooklyn, NY, USA",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val pickle = Pet(
    "2",
    "Pickle",
    PetType.Dog,
    "Pickle is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",
    "https://images.unsplash.com/photo-1598133894008-61f7fdb8cc3a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    Gender.Female,
    2.0f,
    "Cross",
    "110 N 3th St, Brooklyn, NY, USA",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)

val dog3 =  Pet(
    "3",
    "Spartan",
    PetType.Dog,
    "Pickle is a bright, sensitive dog who enjoys play with his human family and responds well to training. As herders bred to move cattle, they are fearless and independent. They are vigilant watchdogs, with acute senses and a “big dog” bark. Families who can meet their bold but kindly Pembroke’s need for activity and togetherness will never have a more loyal, loving pet.",

    "https://images.unsplash.com/photo-1503256207526-0d5d80fa2f47?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1233&q=80",
    Gender.Male,
    3.0f,
    "Border Collie",
    "110 N 3th St, Brooklyn, NY, USA",
    ZonedDateTime.of(2015, 2, 3, 8, 50, 0, 0, ZoneId.systemDefault())
)